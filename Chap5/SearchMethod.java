package com.ums.algorithm.Chap5;

import com.ums.algorithm.Chap2.SimpleUtil;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/01/16:05
 * @Description
 */

public class SearchMethod {
    /**
     * 确定性的查找算法
     *
     * @param arr
     * @param target
     * @return
     */
    public static int deterministicSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;//doesn't exit
    }

    /**
     * 随机查找算法
     *
     * @param arr
     * @param target
     * @return
     */
    public static int randomSearch(int[] arr, int target) {
        PermuteBySorting.permuteBySorting(arr);//随机化初始
        boolean[] hasSearch = new boolean[arr.length];
        Random random = new Random();
        while (true) {
            int index = random.nextInt(arr.length);
            hasSearch[index] = true;
            if (arr[index] == target) {
                return index;
            }
            if (isAllHasSearched(hasSearch)) {
                return -1;
            }
        }
    }

    public static void testForRandomSearch(int maxTestTimes) {
        Random r = new Random();
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(5, 10);
            arr = SimpleUtil.deduplicate(arr);
            int target = r.nextInt(10);
            if (randomSearch(arr, target) != deterministicSearch(arr, target)) {
                System.out.println("Sorry test failed");
                SimpleUtil.printArr(arr);
                return;
            }
        }
        System.out.println("Nice test Passed");


    }

    public static boolean isAllHasSearched(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        testForRandomSearch(10000);
    }

}
