package com.ums.algorithm.Chap7;

import com.ums.algorithm.Chap2.SimpleUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/05/15:00
 * @Description
 */

public class HoarePartition {
    /**
     * Hoare的划分方法
     * 7-1
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int hoarePartition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo - 1;
        int j = hi + 1;
        while (true) {
            do {
                j = j - 1;
            } while (arr[j] > pivot);
            do {
                i = i + 1;
            } while (arr[i] < pivot);
            if (i < j) {
                SimpleUtil.swap(arr, i, j);
            } else {
                return j;
            }

        }
    }

    /**
     * 测试
     *
     * @param maxTestTimes
     */
    public static void testForHoareQuickSort(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(5, 10);
            hoareQuickSort(arr, 0, arr.length - 1);
            if (!SimpleUtil.isOrdered(arr)) {
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");

    }

    /**
     * 主调程序
     *
     * @param arr
     * @param lo
     * @param hi
     */
    public static void hoareQuickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = hoarePartition(arr, lo, hi);
            hoareQuickSort(arr, lo, pivot);
            hoareQuickSort(arr, pivot + 1, hi);
        }
    }

    public static void main(String[] args) {
        testForHoareQuickSort(100);

    }
}
