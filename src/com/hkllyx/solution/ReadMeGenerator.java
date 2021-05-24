package com.hkllyx.solution;

import com.hkllyx.solution.info.Difficulty;
import com.hkllyx.solution.info.Fail;
import com.hkllyx.solution.info.Solution;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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
        String parentPkg = "com.hkllyx.solution";
        String pkgRoot = "src/com/hkllyx/solution/";
        Map<String, String> pkgNameMap = new HashMap<>();
        pkgNameMap.put("LeetCode", "leetcode");
        File readMe = new File("README.md");
        try (PrintWriter writer = new PrintWriter("README.md")) {
            if (!readMe.exists() && !readMe.createNewFile()) {
                throw new IllegalStateException("创建文件失败");
            }
            writer.printf("# Solutions%n%n");
            for (Map.Entry<String, String> entry : pkgNameMap.entrySet()) {
                writer.printf("## %s%n%n", entry.getKey());
                File pkgFile = new File(pkgRoot, entry.getValue());
                List<Problem> problems = new ArrayList<>();
                if (pkgFile.exists() && pkgFile.isDirectory()) {
                    for (File clsFile : Objects.requireNonNull(pkgFile.listFiles())) {
                        String fileName = clsFile.getName();
                        if (fileName.endsWith(".java")) {
                            String clsName = String.format("%s.%s.%s", parentPkg, entry.getValue(),
                                    fileName.substring(0, fileName.length() - 5));
                            Class<?> cls = Class.forName(clsName);
                            if (cls.isAnnotationPresent(Solution.class) && !cls.isAnnotationPresent(Fail.class)) {
                                Solution solution = cls.getAnnotation(Solution.class);
                                problems.add(Problem.of(solution.no(), cls.getSimpleName(), solution.difficulty(),
                                        clsFile.getPath()));
                            }
                        }
                    }
                }
                problems.stream().sorted().forEach(writer::println);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class Problem implements Comparable<Problem> {
        private String no;
        private String name;
        private Difficulty difficulty;
        private String path;

        public static Problem of(String no, String name, Difficulty difficulty, String path) {
            Problem problem = new Problem();
            problem.no = no;
            problem.name = name;
            problem.difficulty = difficulty;
            problem.path = path.replaceAll("\\\\", "/");
            return problem;
        }

        public String no() {
            return no;
        }

        @Override
        public String toString() {
            return String.format("- [%s. %s [%s]](%s)", no, name, difficulty.desc(), path);
        }

        @Override
        public int compareTo(Problem o) {
            int i = 0, j = 0;
            while (i < this.no.length() && j < o.no.length()) {
                char ic = this.no.charAt(i++);
                char jc = o.no.charAt(j++);
                if (Character.isDigit(ic) && Character.isDigit(jc)) {
                    int tn = ic - '0', on = jc - '0';
                    while (i < this.no.length() && Character.isDigit((ic = this.no.charAt(i++)))) {
                        tn = tn * 10 + ic - '0';
                    }
                    while (j < o.no.length() && Character.isDigit((jc = o.no.charAt(j++)))) {
                        on = on * 10 + jc - '0';
                    }
                    if (tn != on) {
                        return Integer.compare(tn, on);
                    }
                    if (ic != jc) {
                        return Character.compare(ic, jc);
                    }
                } else if (Character.isDigit(ic)) {
                    return -1;
                } else if (Character.isDigit(jc)) {
                    return 1;
                } else {
                    if (ic != jc) {
                        return Character.compare(ic, jc);
                    }
                }
            }
            return Integer.compare(this.no.length() - i, o.no.length() - j);
        }
    }
}
