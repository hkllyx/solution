package com.hkllyx.solution.util.info;

/**
 * @author xiaoyong3
 * @date 2021/08/28
 */
public enum Status {
    ACCEPTED("通过", '✔'), FAILED("失败", '✘'), HELPED("帮助", '⚑');

    private final String desc;
    private final char symbol;

    Status(String desc, char symbol) {
        this.desc = desc;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return desc;
    }

    public char getSymbol() {
        return symbol;
    }
}
