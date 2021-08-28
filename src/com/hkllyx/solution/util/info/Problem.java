package com.hkllyx.solution.util.info;

/**
 * @author xiaoyong3
 * @date 2021/08/28
 */
public class Problem implements Comparable<Problem> {
    private final String path;
    private final String name;
    private final String no;
    private final Difficulty difficulty;
    private final String url;
    private final Status status;

    public Problem(String path, String name, String no, Difficulty difficulty, String url, Status status) {
        this.path = path;
        this.name = name;
        this.no = no;
        this.difficulty = difficulty;
        this.url = url;
        this.status = status;
    }

    @Override
    public int compareTo(Problem op) {
        String tn = no, on = op.no;
        int i = 0, j = 0, tl = tn.length(), ol = on.length();
        while (i < tl && j < ol) {
            char tc = tn.charAt(i++), oc = on.charAt(j++);
            if (isDigit(tc) && isDigit(oc)) {
                int ts = tc - '0', os = oc - '0';
                while (i < tl && isDigit((tc = tn.charAt(i++)))) {
                    ts = ts * 10 + tc - '0';
                }
                while (j < ol && isDigit((oc = on.charAt(j++)))) {
                    os = os * 10 + oc - '0';
                }
                if (ts != os) {
                    return Integer.compare(ts, os);
                }
            } else if (isDigit(tc)) {
                return -1;
            } else if (isDigit(oc)) {
                return 1;
            } else if (tc != oc) {
                return Character.compare(tc, oc);
            }
        }
        return Integer.compare(tl - i, ol - j);
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    @Override
    public String toString() {
        return String.format("- [%s. %s [%s%s]](%s)", no, name, difficulty, status, path);
    }
}
