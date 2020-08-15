package com.ums.algorithm.Chap6;

import com.ums.algorithm.Chap2.SimpleUtil;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/02/14:09
 * @Description
 */

public class HeapSort {
    /**
     * 堆排序算法
     *
     * @param arr
     * @param heapSize
     */
    public static void heapSort(int[] arr, int heapSize) {
        BuildMaxHeap.buildMaxHeap(arr, heapSize);
        while (heapSize > 0) {
            SimpleUtil.swap(arr, 0, heapSize - 1);
            heapSize = heapSize - 1;
            MaxHeapify.maxHeapify2(arr, 0, heapSize);

        }
    }

    public static void heapSort(int[] arr) {
        heapSort(arr, arr.length);
    }

    /**
     * 测试类
     *
     * @param maxTestTimes
     */
    public static void testForHeapSort(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(10, 5);
            int[] dest = SimpleUtil.copyArray(arr, 0);
            heapSort(arr);
            Arrays.sort(dest);
            boolean flag = SimpleUtil.isEqualArr(arr, dest);
            if (!flag) {
                System.out.println("Sorry test Failed");
            }
        }
        System.out.print("Nice test passed");

    }

    public static void main(String[] args) {


    }


}
