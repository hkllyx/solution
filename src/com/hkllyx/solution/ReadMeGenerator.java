package com.hkllyx.solution;

import com.hkllyx.solution.util.info.Difficulty;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 生成 README.md
 *
 * @author hkllyx
 * @date 2021/04/19
 */
public class ReadMeGenerator {
    private ReadMeGenerator() {
    }

    public static void main(String[] args) {
        ReadMeGenerator generator = new ReadMeGenerator();
        Map<String, String> libMap = new HashMap<>();
        libMap.put("LeetCode", "leetcode");
        generator.generate(libMap);
    }

    public void generate(Map<String, String> libMap) {
        // 配置
        String rootPackage = "com.hkllyx.solution";
        String rootPath = "src/com/hkllyx/solution/";
        File readMe = new File("README.md");
        // 写README文件
        try (PrintWriter writer = new PrintWriter("README.md")) {
            if (!readMe.exists() && !readMe.createNewFile()) {
                throw new IllegalStateException("创建文件失败");
            }

            // 主标题
            writer.printf("# Solutions%n%n");
            for (Map.Entry<String, String> entry : libMap.entrySet()) {
                File libFile = new File(rootPath, entry.getValue());
                // 扫描文件
                List<Node> nodes = new ArrayList<>();
                if (libFile.exists() && libFile.isDirectory()) {
                    for (File classFile : Objects.requireNonNull(libFile.listFiles())) {
                        String fileName = classFile.getName();
                        if (fileName.endsWith(".java")) {
                            String className = String.format("%s.%s.%s", rootPackage, entry.getValue(),
                                    fileName.substring(0, fileName.length() - 5));
                            Class<?> clazz = Class.forName(className);
                            Solution solution = clazz.getAnnotation(Solution.class);
                            if (solution != null) {
                                nodes.add(new Node(classFile, clazz, solution));
                            }
                        }
                    }
                }

                // 二级标题
                writer.printf("## %s%n%n", entry.getKey());

                // 统计信息
                printStatistic(writer, nodes);

                // 题目列表
                fixNodes(nodes).stream().sorted().forEach(writer::println);
                writer.println();

            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Node> fixNodes(List<Node> nodes) {
        Map<Class<?>, Node> nodeMap = nodes.stream()
                .collect(Collectors.toMap(Node::getClazz, Function.identity()));
        for (Node value : nodeMap.values()) {
            fixStatus(nodeMap, value);
        }
        return nodes;
    }

    private void fixStatus(Map<Class<?>, Node> nodeMap, Node current) {
        if (current.isFixed()) {
            return;
        }
        Class<?> superclass = current.getClazz().getSuperclass();
        if (superclass.isAnnotationPresent(Solution.class)) {
            Node supNode = nodeMap.get(superclass);
            fixStatus(nodeMap, supNode);
            current.setStatus(supNode.getStatus());
        }
        current.setFixed(true);
    }

    private static void printStatistic(PrintWriter writer, List<Node> nodes) {
        // 计算单元格长度、列数
        int cellLen = Integer.toString(nodes.size()).length();
        for (Status value : Status.values()) {
            cellLen = Math.max(cellLen, value.toString().length());
        }
        for (Difficulty value : Difficulty.values()) {
            cellLen = Math.max(cellLen, value.toString().length());
        }
        cellLen += 2;
        int columns = Status.values().length + 2;

        // 头、分隔符、合计一行合计信息
        RowBuilder header = new RowBuilder(cellLen, columns).add();
        RowBuilder separator = new RowBuilder(cellLen, columns, '-');
        RowBuilder sumRow = new RowBuilder(cellLen, columns).add("合计");
        Map<Status, Integer> statusCount = nodes.stream()
                .collect(Collectors.groupingBy(Node::getStatus, Collectors.summingInt(e -> 1)));
        for (Status status : Status.values()) {
            header.add(status.toString());
            sumRow.add(Integer.toString(statusCount.getOrDefault(status, 0)));
        }
        header.add("合计");
        sumRow.add(Integer.toString(nodes.size()));
        writer.println(header);
        writer.println(separator);
        // 分组计数
        Map<Difficulty, Map<Status, Integer>> tableCount = nodes.stream().collect(
                Collectors.groupingBy(n -> n.getSolution().difficulty(),
                        Collectors.groupingBy(Node::getStatus, Collectors.summingInt(e -> 1))));
        for (Difficulty difficulty : Difficulty.values()) {
            RowBuilder row = new RowBuilder(cellLen, columns).add(difficulty.toString());
            int sum = 0;
            Map<Status, Integer> statusMap = tableCount.getOrDefault(difficulty, Collections.emptyMap());
            for (Status status : Status.values()) {
                int num = statusMap.getOrDefault(status, 0);
                row.add(Integer.toString(num));
                sum += num;
            }
            row.add(Integer.toString(sum));
            writer.println(row);
        }
        writer.println(sumRow);
        writer.println();
    }

    private static class Node implements Comparable<Node> {
        private final File file;
        private final Class<?> clazz;
        private final Solution solution;
        private Status status;
        private String title;
        private boolean fixed;

        public Node(File file, Class<?> clazz, Solution solution) {
            this.file = file;
            this.clazz = clazz;
            this.solution = solution;
            this.status = solution.status();
            this.title = solution.title();
            if (title.isEmpty()) {
                title = clazz.getSimpleName();
            }
        }

        public Class<?> getClazz() {
            return clazz;
        }

        public Solution getSolution() {
            return solution;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public boolean isFixed() {
            return fixed;
        }

        public void setFixed(boolean fixed) {
            this.fixed = fixed;
        }

        @Override
        public int compareTo(Node o) {
            String tn = solution.no(), on = o.solution.no();
            int i = 0, j = 0, tl = tn.length(), ol = on.length();
            while (i < tl && j < ol) {
                char tc = tn.charAt(i++), oc = on.charAt(j++);
                if (isDigit(tc) && isDigit(oc)) {
                    int ts = tc - '0', os = oc - '0';
                    while (i < tl && isDigit((tc = tn.charAt(i++)))) {
                        ts = ts * 10 + tc - '0';
                    }
                    while (j < ol && isDigit((oc = on.charAt(j++)))) {
                        os = os * 10 + oc - '0';
                    }
                    if (ts != os) {
                        return Integer.compare(ts, os);
                    }
                } else if (isDigit(tc)) {
                    return -1;
                } else if (isDigit(oc)) {
                    return 1;
                } else if (tc != oc) {
                    return Character.compare(tc, oc);
                }
            }
            return Integer.compare(tl - i, ol - j);
        }

        private boolean isDigit(char c) {
            return '0' <= c && c <= '9';
        }

        @Override
        public String toString() {
            String filePath = file.getPath().replaceAll("\\\\{1,2}", "/");
            return String.format("- %s [%s. %s [%s]](%s)", status.getSymbol(), solution.no(), title,
                    solution.difficulty(), filePath);
        }
    }

    private static class RowBuilder {
        private final String delimiter;
        private final String prefix;
        private final String suffix;
        private final char padding;
        private final int cellLen;
        private final int columns;

        private char[] value;
        private int bound;
        private int index;

        public RowBuilder(String delimiter, String prefix, String suffix, char padding, int cellLen, int columns) {
            if (prefix == null || suffix == null || delimiter == null) {
                throw new IllegalArgumentException("delimiter, suffix and prefix must not be null!");
            }
            if (cellLen < 0 || columns < 0) {
                throw new IllegalArgumentException("column and cellLen must greater than 0!");
            }
            this.delimiter = delimiter;
            this.prefix = prefix;
            this.suffix = suffix;
            this.padding = padding;
            this.cellLen = cellLen;
            this.columns = columns;
        }

        public RowBuilder(int cellLen, int columns, char padding) {
            this("|", "|", "|", padding, cellLen, columns);
        }

        public RowBuilder(int cellLen, int columns) {
            this("|", "|", "|", ' ', cellLen, columns);
        }

        private void appendPrefix() {
            // 初始数组
            int preLen = prefix.length();
            bound = preLen + delimiter.length() * (columns - 1) + cellLen * columns;
            value = new char[bound + suffix.length()];
            // 添加前缀
            if (preLen > 0) {
                prefix.getChars(0, preLen, value, 0);
                index = preLen;
            }
        }

        private void appendDelimiter() {
            if (index >= bound) {
                throw new IllegalStateException("overflow!");
            }
            int delLen = delimiter.length();
            if (delLen > 0) {
                // 添加分隔符
                delimiter.getChars(0, delLen, value, index);
                index += delLen;
            }
        }

        private void appendSuffix() {
            int sufLen = suffix.length();
            if (sufLen > 0) {
                // 添加分隔符
                suffix.getChars(0, sufLen, value, index);
                index += sufLen;
            }
        }

        public RowBuilder add(CharSequence cs) {
            if (value == null) {
                appendPrefix();
            } else {
                appendDelimiter();
            }
            // 目标字符串两侧留有一个填充
            value[index++] = padding;
            int i = 0, len = cellLen - 2;
            // 添加目标字符串
            if (cs != null) {
                int min = Math.min(cs.length(), len);
                while (i < min) {
                    value[index++] = cs.charAt(i++);
                }
            }
            // 填充剩余单元格空间
            while (i++ <= len) {
                value[index++] = padding;
            }
            return this;
        }

        public RowBuilder add() {
            return add(null);
        }

        @Override
        public String toString() {
            int initIndex = index;
            while (value == null || index < bound) {
                add();
            }
            appendSuffix();
            index = initIndex;
            return new String(value);
        }
    }
}
