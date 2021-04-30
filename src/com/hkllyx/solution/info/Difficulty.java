package com.hkllyx.solution.info;

/**
 * @author hkllyx
 * @date 2021/04/19
 */
public enum Difficulty {
    SIMPLE("简单", "*"), MEDIUM("中等", ""), HARD("苦难", "**");

    private final String desc;
    private final String style;

    Difficulty(String desc, String style) {
        this.desc = desc;
        this.style = style;
    }

    public String desc() {
        return desc;
    }

    public String style() {
        return style;
    }
}
