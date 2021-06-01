package com.hkllyx.solution.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hkllyx
 * @date 2021/03/26
 */
public class TestUtils {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    public static final Map<Class<?>, Object> OBJECT_CACHE = new HashMap<>();
    public static final Map<Class<?>, List<Method>> METHODS_CACHE = new HashMap<>();

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
        } else if (o1 == o2) {
            return true;
        } else if (o1 instanceof Object[] && o2 instanceof Object[]) {
            Object[] a1 = (Object[]) o1, a2 = (Object[]) o2;
            int length = a1.length;
            if (a2.length != length) {
                return false;
            }
            for (int i = 0; i < length; i++) {
                if (!except(a1[i], a2[i])) {
                    return false;
                }
            }
            return true;
        } else if (o1 instanceof byte[] && o2 instanceof byte[]) {
            return Arrays.equals((byte[]) o1, (byte[]) o2);
        } else if (o1 instanceof short[] && o2 instanceof short[]) {
            return Arrays.equals((short[]) o1, (short[]) o2);
        } else if (o1 instanceof int[] && o2 instanceof int[]) {
            return Arrays.equals((int[]) o1, (int[]) o2);
        } else if (o1 instanceof long[] && o2 instanceof long[]) {
            return Arrays.equals((long[]) o1, (long[]) o2);
        } else if (o1 instanceof char[] && o2 instanceof char[]) {
            return Arrays.equals((char[]) o1, (char[]) o2);
        } else if (o1 instanceof float[] && o2 instanceof float[]) {
            return Arrays.equals((float[]) o1, (float[]) o2);
        } else if (o1 instanceof double[] && o2 instanceof double[]) {
            return Arrays.equals((double[]) o1, (double[]) o2);
        } else if (o1 instanceof boolean[] && o2 instanceof boolean[]) {
            return Arrays.equals((boolean[]) o1, (boolean[]) o2);
        } else if (o1 instanceof List && o2 instanceof List) {
            List<?> l1 = (List<?>) o1, l2 = (List<?>) o2;
            int size = l1.size();
            if (l2.size() != size) {
                return false;
            }
            for (int i = 0; i < l1.size(); i++) {
                if (!except(l1.get(i), l2.get(i))) {
                    return false;
                }
            }
            return true;
        } else if (o1 instanceof Set && o2 instanceof Set) {
            Set<?> s1 = (Set<?>) o1, s2 = (Set<?>) o2;
            int size = s1.size();
            if (s2.size() != size) {
                return false;
            }
            for (Object i : s1) {
                if (!s2.contains(i)) {
                    return false;
                }
            }
            return true;
        } else if (o1 instanceof Map && o2 instanceof Map) {
            return except(((Map<?, ?>) o1).entrySet(), ((Map<?, ?>) o2).entrySet());
        } else {
            return o1.equals(o2);
        }
    }

    public static void assertion(Class<?> clazz, Object expect, Object... args) {
        try {
            Object obj = OBJECT_CACHE.get(clazz);
            List<Method> methods = METHODS_CACHE.get(clazz);
            if (obj == null) {
                synchronized (clazz) {
                    if ((obj = OBJECT_CACHE.get(clazz)) == null) {
                        obj = clazz.newInstance();
                        OBJECT_CACHE.put(clazz, obj);
                        methods = new ArrayList<>();
                        for (Method method : clazz.getDeclaredMethods()) {
                            if (Modifier.isPublic(method.getModifiers()) && method.isAnnotationPresent(Test.class)) {
                                methods.add(method);
                            }
                        }
                        METHODS_CACHE.put(clazz, methods);
                    }
                }
            }
            for (Method method : methods) {
                if (method.getParameters().length == args.length) {
                    String argsString = Arrays.stream(args).map(TestUtils::toString).collect(Collectors.joining(", "));
                    long start = System.currentTimeMillis();
                    Object result = method.invoke(obj, args);
                    long cost = System.currentTimeMillis() - start;
                    boolean equals = except(expect, result);
                    System.out.printf("[%s::%s][%dms] %s\n"
                                    + "    输入: %s\n"
                                    + "    输出: %s\n"
                                    + "    预期: %s\n",
                            clazz.getSimpleName(), method.getName(), cost, equals ? "通过。" : "失败！",
                            argsString, toString(result), toString(expect));
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }
}
