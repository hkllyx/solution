package com.hkllyx.solution.info;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hkllyx
 * @date 2021/04/19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Solution {
    String no();

    Difficulty difficulty();

    String url();
}
