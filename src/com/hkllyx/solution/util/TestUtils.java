package com.hkllyx.solution.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author hkllyx
 * @date 2021/03/26
 */
public class TestUtils {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private static String toString(Object obj) {
        if (obj instanceof Object[]) {
            return Arrays.deepToString((Object[]) obj);
        } else if (obj instanceof byte[]) {
            return Arrays.toString((byte[]) obj);
        } else if (obj instanceof short[]) {
            return Arrays.toString((short[]) obj);
        } else if (obj instanceof int[]) {
            return Arrays.toString((int[]) obj);
        } else if (obj instanceof long[]) {
            return Arrays.toString((long[]) obj);
        } else if (obj instanceof char[]) {
            return Arrays.toString((char[]) obj);
        } else if (obj instanceof float[]) {
            return Arrays.toString((float[]) obj);
        } else if (obj instanceof double[]) {
            return Arrays.toString((double[]) obj);
        } else if (obj instanceof boolean[]) {
            return Arrays.toString((boolean[]) obj);
        } else {
            return String.valueOf(obj);
        }
    }

    private static boolean except(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        } else if (o1.getClass().isArray()) {
            return Objects.deepEquals(o1, o2);
        } else {
            return Objects.equals(o1, o2);
        }
    }

    public static <T> void assertion(Class<T> clazz, Object expect, Object... args) {
        String expectString = toString(expect);
        List<String> errorList = new ArrayList<>(16);
        try {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Test.class) && Modifier.isPublic(method.getModifiers())
                        && method.getParameters().length == args.length) {
                    long start = System.currentTimeMillis();
                    Object result = method.invoke(clazz.newInstance(), args);
                    long cost = System.currentTimeMillis() - start;
                    boolean equals = except(expect, result);
                    if (!equals) {
                        errorList.add(method.getName());
                    }
                    System.out.printf("[%s]-[%s::%s]-[%dms]-[%s] expect = %s, result = %s.\n",
                            DATE_TIME_FORMATTER.format(LocalDateTime.now()), clazz.getSimpleName(), method.getName(),
                            cost, equals, expectString, toString(result));
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        if (!errorList.isEmpty()) {
            throw new IllegalStateException(clazz.getSimpleName() + "::" + errorList);
        }
    }
}
