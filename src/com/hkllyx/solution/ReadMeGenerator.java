package com.hkllyx.solution;

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
                // 题目列表
                fixNodes(nodes).stream().sorted().forEach(writer::println);
                writer.println();
                // 统计信息
                writer.printf("共 %d", nodes.size());
                Map<Status, Long> countingMap = nodes.stream()
                        .collect(Collectors.groupingBy(Node::getStatus, Collectors.counting()));
                for (Status status : Status.values()) {
                    if (countingMap.containsKey(status)) {
                        writer.printf("， %s%s %d", status.getSymbol(), status, countingMap.get(status));
                    }
                }
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

    private static class Node implements Comparable<Node> {
        private final File file;
        private final Class<?> clazz;
        private final Solution solution;
        private Status status;
        private boolean fixed;

        public Node(File file, Class<?> clazz, Solution solution) {
            this.file = file;
            this.clazz = clazz;
            this.solution = solution;
            this.status = solution.status();
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
            return String.format("- %s [%s. %s [%s]](%s)", status.getSymbol(), solution.no(), clazz.getSimpleName(),
                    solution.difficulty(), filePath);
        }
    }
}
