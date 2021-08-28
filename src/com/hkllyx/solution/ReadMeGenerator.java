package com.hkllyx.solution;

import com.hkllyx.solution.util.info.Problem;
import com.hkllyx.solution.util.info.Solution;
import com.hkllyx.solution.util.info.Status;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        // 配置
        String rootPackage = "com.hkllyx.solution";
        String rootPath = "src/com/hkllyx/solution/";
        Map<String, String> libMap = new HashMap<>();
        libMap.put("LeetCode", "leetcode");
        File readMe = new File("README.md");
        // 写README文件
        try (PrintWriter writer = new PrintWriter("README.md")) {
            if (!readMe.exists() && !readMe.createNewFile()) {
                throw new IllegalStateException("创建文件失败");
            }
            // 主标题
            writer.printf("# Solutions%n%n");
            for (Map.Entry<String, String> entry : libMap.entrySet()) {
                // 二级标题
                writer.printf("## %s%n%n", entry.getKey());
                File libFile = new File(rootPath, entry.getValue());
                // 扫描文件
                Map<String, Node> nodeMap = new HashMap<>();
                if (libFile.exists() && libFile.isDirectory()) {
                    for (File classFile : Objects.requireNonNull(libFile.listFiles())) {
                        String fileName = classFile.getName();
                        if (fileName.endsWith(".java")) {
                            String className = String.format("%s.%s.%s", rootPackage, entry.getValue(),
                                    fileName.substring(0, fileName.length() - 5));
                            Class<?> clazz = Class.forName(className);
                            Solution solution = clazz.getAnnotation(Solution.class);
                            if (solution != null) {
                                nodeMap.put(className, new Node(classFile, clazz, solution));
                            }
                        }
                    }
                }
                // 转化为Problem
                nodeMap.values()
                Map<String, Problem> problemMap = new HashMap<>(classMap.size());

                problems.stream().sorted().forEach(writer::println);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class Node {
        private final File file;
        private final Class<?> clazz;
        private final Solution solution;
        private Status status;
        private boolean complete;

        public Node(File file, Class<?> clazz, Solution solution) {
            this.file = file;
            this.clazz = clazz;
            this.solution = solution;
            this.status = solution.status();
        }

        public boolean isComplete() {
            return complete;
        }

        public void setComplete(boolean complete) {
            this.complete = complete;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public Problem toProblem() {
            return new Problem(file.getPath(), clazz.getSimpleName(), solution.no(), solution.difficulty(),
                    solution.url(), status);
        }
    }
}
