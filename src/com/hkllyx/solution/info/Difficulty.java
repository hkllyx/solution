package com.hkllyx.solution.info;

/**
 * @author hkllyx
 * @date 2021/04/19
 */
public enum Difficulty {
    SIMPLE("简单"), MEDIUM("中等"), HARD("苦难");

    private final String desc;

    Difficulty(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
