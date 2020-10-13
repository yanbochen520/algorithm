package  Chap4;

import  Chap2.SimpleUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/23/16:54
 * @Description
 */

public class MongeArray {
    /**
     * 根据推论判定一个阵列是否为Monge阵列
     *
     * @param arr
     * @return
     */
    public static boolean isMongeArray(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (arr[i][j] + arr[i + 1][j + 1] > arr[i][j + 1] + arr[i + 1][j]) {
                    return false;
                }
            }
        }

        return true;
    }
    /**
     * 4.6-d Mongo Array 最左的最小元素
     * 迭代版
     * @param arr
     * @param lo
     * @param hi
     */
    public static void leftmostMinimumOfMongoArray(int[][] arr, int lo, int hi) {
        int start = 0;
        while (lo <= hi) {
            start = SimpleUtil.findMinIndex(arr[lo], start, arr.length - 1);
            System.out.println(start);
            lo = lo + 1;

        }

    }

    /**
     * 4.6-d Mongo Array 最左的最小元素
     * 递归版
     * @param arr
     * @param lo
     * @param hi
     */
    public static void leftmostMinimumOfMongoArray(int[][] arr, int lo, int hi, int start) {
        if (lo <= hi) {
            start = SimpleUtil.findMinIndex(arr[lo], start, arr[lo].length - 1);
            System.out.println(start);
            leftmostMinimumOfMongoArray(arr, lo + 1, hi, start);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{18, 10, 13}, {23, 22, 16}, {24, 28, 22}};
        leftmostMinimumOfMongoArray(arr, 0, arr.length - 1, 0);
    }
}
