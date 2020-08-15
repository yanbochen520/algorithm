package com.ums.algorithm.Chap2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/16/15:21
 * @Description
 */

public class SelectionSort {
    /**
     * 习题2.2-2
     * 选择排序
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minValue= Integer.MAX_VALUE;
            int j;
            int temp=0;
            for (j = i; j <=arr.length - 1; j++) {
                if (arr[j] <minValue) {
                    minValue = arr[j];
                    temp=j;
                }
            }
            SimpleUtil.swap(arr, i, temp);
        }

    }
}
