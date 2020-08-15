package com.ums.algorithm.Chap2;


import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/16/19:48
 * @Description
 */

public class BinarySearch {
    /**
     * 二分查找递归版
     *
     * @param arr
     * @param target:待查找的数
     * @return
     */
    public static int binarySearch(int[] arr, int target, int lo, int hi) {
        if (lo > hi) {
            return hi  ;//查找失败
        } else {
            int mid = (hi + lo) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return binarySearch(arr, target, lo, mid - 1);
            } else {
                return binarySearch(arr, target, mid + 1, hi);
            }
        }
    }

    /**
     * 线性查找
     *
     * @param arr
     * @param target
     * @return
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isExist(int[][] matrix, int key) {
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0;
        int j = column - 1;
        while (i <= row - 1 && j >= 0) {
            if (matrix[i][j] == key) {
                return true;
            } else if (matrix[i][j] < key) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }
        return false;
    }


    public static void testForBinarySearch(int maxTestTimes, int target) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(5, 10);
            arr=SimpleUtil.deduplicate(arr);//去重
            Arrays.sort(arr);
            Random r = new Random();
            target = r.nextInt(target) + 1;
            boolean flag = binarySearch(arr, target, 0, arr.length - 1) == linearSearch(arr, target);
            if (!flag) {
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");
    }

    public static void main(String[] args) {
//        //testForInsertionSort(1000, 5);
//        int[] arr={0,2,3};
//        int a=binarySearch(arr,-1,0,arr.length-1);
//        System.out.println(a);
//        int[][] matrix={{0,1,2,5},{2,3,4,7},{4,4,4,8},{5,7,7,9}};
        int[][] matrix={{}};
        isExist(matrix,0);
        String str="";

    }


}
