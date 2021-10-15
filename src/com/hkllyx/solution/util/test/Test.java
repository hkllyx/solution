package com.hkllyx.solution.util.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hkllyx
 * @date 2021/03/29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    /**
     * 描述
     *
     * @return 描述
     */
    String value() default "";

    /**
     * 启用测试
     *
     * @return 启用测试
     */
    boolean active() default true;

    /**
     * 消耗时间 ms
     *
     * @return 消耗时间
     */
    int mills() default -1;

    /**
     * 消耗内存 MB
     *
     * @return 消耗内存
     */
    double space() default -1;
}
