package com.hkllyx.solution.ops;

/**
 * @author xiaoyong3
 * @date 2021/11/16
 */
public interface ArrayOps {

    /**
     * 交换数组i、j处的值
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     */
    default void swap(byte[] arr, int i, int j) {
        byte tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 交换数组i、j处的值
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     */
    default void swap(short[] arr, int i, int j) {
        short tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 交换数组i、j处的值
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     */
    default void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 交换数组i、j处的值
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     */
    default void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 交换数组i、j处的值
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     */
    default void swap(long[] arr, int i, int j) {
        long tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    default void swap(float[] arr, int i, int j) {
        float tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 交换数组i、j处的值
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     */
    default void swap(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 交换数组i、j处的值
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     */
    default void swap(boolean[] arr, int i, int j) {
        boolean tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 交换数组i、j处的值
     *
     * @param arr 数组
     * @param i   i
     * @param j   j
     * @param <T> 类型
     */
    default <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
