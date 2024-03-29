package com.hkllyx.solution.util.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hkllyx
 * @date 2021/03/26
 */
public class Assertions {
    private static final Map<Class<?>, Object> OBJECT_CACHE = new HashMap<>();
    private static final Map<Class<?>, List<Method>> METHODS_CACHE = new HashMap<>();

    /**
     * 将对象转换成字符串
     */
    public static String toString(Object obj) {
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

    /**
     * 判断后两个对象是否相等。注意：<br/>
     * <ul>
     *     <li>1. 如果两个对象都是null，返回true</li>
     *     <li>
     *         2. 如果对象均是java.util.List、Set、Map容器对象构成，则只比较值，而忽略容器类型是否相同。
     *         例如，一个ArrayList[1, 2]和LinkedList[1, 2]，则认为是相等的
     *      </li>
     * </ul>
     */
    private static boolean equals(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        } else if (o1 == o2) {
            return true;
        } else if (o1 instanceof Set && o2 instanceof Set) {
            String s1 = ((Set<?>) o1).stream().map(Assertions::toString).sorted().collect(Collectors.joining(","));
            String s2 = ((Set<?>) o2).stream().map(Assertions::toString).sorted().collect(Collectors.joining(","));
            return s1.equals(s2);
        } else if (o1 instanceof Map && o2 instanceof Map) {
            return equals(((Map<?, ?>) o1).entrySet(), ((Map<?, ?>) o2).entrySet());
        } else {
            return toString(o1).equals(toString(o2));
        }
    }

    public static void assertEquals(Object o1, Object o2) {
        boolean equals = equals(o1, o2);
        System.out.printf("[%s][%dms] %s\n"
                        + "    输入1: %s\n"
                        + "    输入2: %s\n",
                getMainClass().getSimpleName(), 0, equals ? "通过" : "失败", toString(o1), toString(o2));
        if (!equals) {
            throw new IllegalStateException("异常！");
        }
    }

    public static void assertExpect(Class<?> clazz, Object expect, Object... args) {
        assert clazz != null;
        try {
            for (Method method : getTestMethods(clazz)) {
                String argsString = args == null ? "null" :
                        Arrays.stream(args).map(Assertions::toString).collect(Collectors.joining(", "));
                long start = System.currentTimeMillis();
                Object result = method.invoke(Modifier.isStatic(method.getModifiers()) ? null :
                        getTestObject(clazz), args);
                long cost = System.currentTimeMillis() - start;
                boolean equals = equals(expect, result);
                System.out.printf("[%s::%s][%dms] %s\n"
                                + "    输入: %s\n"
                                + "    输出: %s\n"
                                + "    预期: %s\n",
                        clazz.getSimpleName(), method.getName(), cost, equals ? "通过。" : "失败！",
                        argsString, toString(result), toString(expect));
                if (!equals) {
                    throw new IllegalStateException("异常！");
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void assertExpect(Object expect, Object... args) {
        assertExpect(getMainClass(), expect, args);
    }

    private static Class<?> getMainClass() {
        try {
            StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if ("main".equals(stackTraceElement.getMethodName())) {
                    return Class.forName(stackTraceElement.getClassName());
                }
            }
        } catch (ClassNotFoundException ex) {
            // Swallow and continue
        }
        throw new IllegalStateException("未找到main函数所在类");
    }

    private static List<Method> getTestMethods(Class<?> clazz) {
        List<Method> methods = METHODS_CACHE.get(clazz);
        if (methods == null) {
            synchronized (clazz) {
                methods = METHODS_CACHE.get(clazz);
                if (methods == null) {
                    methods = new ArrayList<>();
                    for (Method method : clazz.getDeclaredMethods()) {
                        if (Modifier.isPublic(method.getModifiers())
                                && method.isAnnotationPresent(Test.class)
                                && method.getAnnotation(Test.class).active()) {
                            methods.add(method);
                        }
                    }
                    METHODS_CACHE.put(clazz, methods);
                }
            }
        }
        return methods;
    }

    private static Object getTestObject(Class<?> clazz) throws InstantiationException, IllegalAccessException {
        Object obj = OBJECT_CACHE.get(clazz);
        if (obj == null) {
            synchronized (clazz) {
                obj = OBJECT_CACHE.get(clazz);
                if (obj == null) {
                    obj = clazz.newInstance();
                    OBJECT_CACHE.put(clazz, obj);
                }
            }
        }
        return obj;
    }
}
