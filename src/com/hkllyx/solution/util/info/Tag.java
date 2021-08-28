package com.hkllyx.solution.util.info;

/**
 * @author hkllyx
 * @date 2021/04/19
 */
public enum Tag {
    ARRAY("数组"),
    DYNAMIC_PROGRAMMING("动态规划"),
    STRING("字符串"),
    MATH("数学"),
    TREE("树"),
    DEPTH_FIRST_SEARCH("深度优先搜索"),
    HASH_TABLE("哈希表"),
    GREEDY("贪心算法"),
    BINARY_SEARCH("二分查找"),
    BREADTH_FIRST_SEARCH("广度优先搜索"),
    TWO_POINTERS("双指针"),
    SORT("排序"),
    BACKTRACKING("回溯算法"),
    DESIGN("设计"),
    BIT_MANIPULATION("位运算"),
    STACK("栈"),
    GRAPH("图"),
    LINKED_LIST("链表"),
    HEAP("堆"),
    RECURSION("递归"),
    UNION_FIND("并查集"),
    SLIDING_WINDOW("滑动窗口"),
    DIVIDE_AND_CONQUER("分治算法"),
    TRIE("字典数"),
    SEGMENT_TREE("线段数"),
    ORDERED_MAP(""),
    QUEUE("队列"),
    GEOMETRY("几何"),
    MINIMAX("极大极小"),
    BINARY_INDEXED_TREE("树状数组"),
    BRAINTEASER("脑筋急转弯"),
    BINARY_SEARCH_TREE("二叉搜索树"),
    LINE_SWEEP(""),
    RANDOM("随机"),
    TOPOLOGICAL_SORT("拓扑排序"),
    MEMOIZATION("记忆化"),
    REJECTION_SAMPLING(""),
    RESERVOIR_SAMPLING("蓄水池抽样");

    private final String desc;

    Tag(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
