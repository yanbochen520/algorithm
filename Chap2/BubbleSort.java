package com.ums.algorithm.Chap2;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/18/19:36
 * @Description
 */

public class BubbleSort {
    /**
     * 2-2
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SimpleUtil.swap(arr, j, j + 1);
                }
            }
        }

    }

    public static void testForInsertionSort(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(5, 10);
            BubbleSort.bubbleSort(arr);
            boolean isOrdered = SimpleUtil.isOrdered(arr);
            if (!isOrdered) {
                SimpleUtil.printArr(arr);
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");

    }

    /**
     * 2-3                                                                                                                                                                                          .
     * @param x
     * @param arr:各项系数
     * @return
     */
    public static int getPolynomialByHornerRule(int x, int[] arr) {
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum = sum * x + arr[i];
        }
        return sum;
    }

    /**
     * 多项式求和暴力破解版
     * @param x
     * @param arr
     * @return
     */
    public static int getPolynomialBF(int x, int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + (int) (arr[i] * Math.pow(x, i));

        }
        return sum;
    }

    public static void testForPolynomialByHornerRule(int testTimes, int x) {
        for (int i = 0; i < testTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(3, 10);
            Random random = new Random();
            x = random.nextInt(x) + 1;
            if (!(getPolynomialByHornerRule(x, arr) == getPolynomialBF(x, arr))) {
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.print("Nice test passed");
    }

    public static void main(String[] args) {
        testForPolynomialByHornerRule(1000000000, 8);

    }

}
