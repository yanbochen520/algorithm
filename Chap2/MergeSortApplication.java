package com.ums.algorithm.Chap2;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/17/19:38
 * @Description
 */

public class MergeSortApplication {
    /**
     * 2.3-7
     * 在数组中，是否存在arr[i],arr[j]使得arr[i]+arr[j]==target,时间复杂度为O(NlogN)
     *
     * @param arr
     * @param target
     * @return
     */
    public static boolean twoNumberSum(int[] arr, int target) {
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] == target) {
                return true;
            } else if (arr[start] + arr[end] < target) {
                start = start + 1;
            } else {
                end = end - 1;
            }

        }
        return false;
    }


    /**
     * 暴力破解算法，时间复杂度为O(N^2)
     *
     * @param arr
     * @param target
     * @return
     */
    public static boolean twoNumberSumBF(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void testForTwoNumberSum(int testTimes, int testNumber) {
        for (int i = 0; i < testTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(10, 10);
            Random r = new Random();
            testNumber = r.nextInt(testNumber) + 1;
            if (!(twoNumberSum(arr, testNumber) == twoNumberSumBF(arr, testNumber))) {
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");
    }

    public static void main(String[] args) {
        testForTwoNumberSum(10000000,10);
    }


}
