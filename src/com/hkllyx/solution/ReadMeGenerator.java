package com.hkllyx.solution;

import com.hkllyx.solution.info.Fail;
import com.hkllyx.solution.info.Solution;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 生成 README.md
 * @author hkllyx
 * @date 2021/04/19
 */
public class ReadMeGenerator {
    public static final Pattern CLASS_PATTERN = Pattern.compile("[a-zA-Z0-9_$]+(?=\\.java)");

    private ReadMeGenerator() {
    }

    public static void main(String[] args) {
        String parentPkg = "com.hkllyx.solution";
        String pkgRoot = "src/com/hkllyx/solution/";
        Map<String, String> pkgNameMap = new HashMap<>();
        pkgNameMap.put("LeetCode", "leetcode");
        File readMe = new File("README.md");
        PrintWriter writer = null;
        try {
            if (!readMe.exists() && !readMe.createNewFile()) {
                throw new IllegalStateException("创建文件失败");
            }
            writer = new PrintWriter("README.md");
            writer.printf("# Solutions%n%n");
            for (Map.Entry<String, String> entry : pkgNameMap.entrySet()) {
                writer.printf("## %s%n%n", entry.getKey());
                File pkgFile = new File(pkgRoot, entry.getValue());
                Map<Class<?>, File> clsMap = new HashMap<>();
                if (pkgFile.exists() && pkgFile.isDirectory()) {
                    for (File clsFile : Objects.requireNonNull(pkgFile.listFiles())) {
                        Matcher matcher = CLASS_PATTERN.matcher(clsFile.getName());
                        if (matcher.find()) {
                            String clsName = String.format("%s.%s.%s", parentPkg, entry.getValue(), matcher.group());
                            Class<?> cls = Class.forName(clsName);
                            if (cls.isAnnotationPresent(Solution.class) && !cls.isAnnotationPresent(Fail.class)) {
                                clsMap.put(cls, clsFile);
                            }
                        }
                    }
                }
                if (!clsMap.isEmpty()) {
                    final List<Class<?>> clss = clsMap.keySet().stream().sorted(Comparator
                            .comparingInt(c -> c.getAnnotation(Solution.class).no())).collect(Collectors.toList());
                    for (Class<?> cls : clss) {
                        writer.printf("- [%d.%s](%s)%n", cls.getAnnotation(Solution.class).no(), cls.getSimpleName(),
                                clsMap.get(cls).getPath().replaceAll("\\\\", "/"));
                    }
                }
                writer.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static String title(String str) {
        if (str.length() < 1) {
            return str;
        } else {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
    }
}
