package com.hkllyx.solution.util.info;

/**
 * @author hkllyx
 * @date 2021/04/19
 */
public enum Difficulty {
    EASY("简单"), MEDIUM("中等"), HARD("困难");

    private final String desc;

    Difficulty(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
