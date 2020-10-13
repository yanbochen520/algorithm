package  Chap5;

import  Chap2.SimpleUtil;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/29/20:38
 * @Description
 */

public class PermuteBySorting {
    /**
     * 随机化的方法一：利用随机优先级进行排序
     * @param arr
     */
    public static void permuteBySorting(int[] arr) {
        int[] randomPriorityArray = new int[arr.length];
        Random random = new Random();
        for (int i = 0; i < randomPriorityArray.length; i++) {
            randomPriorityArray[i] = random.nextInt((int) Math.pow(arr.length, 3)) + 1;
        }
        sortArrayUsingPriorityArrayAsSortKeys(arr, randomPriorityArray);
    }

    /**
     * 原地随机化算法
     * @param arr
     */
    public static  void randomizeInPlace(int[] arr){
        for(int i=0;i<arr.length;i++){
            SimpleUtil.swap(arr,i,RandomInteger.random(i,arr.length-1));
        }

    }

    /**
     * 利用优先级数组对原始数组进行排序
     * @param arr
     * @param priorityArray
     */
    public static void sortArrayUsingPriorityArrayAsSortKeys(int[] arr, int[] priorityArray) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            int tempPriority = priorityArray[i];
            int temp = arr[i];
            for (j = i; j > 0 && tempPriority < priorityArray[j - 1]; j--) {
                priorityArray[j] = priorityArray[j - 1];
                arr[j] = arr[j - 1];
            }
            priorityArray[j] = tempPriority;
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] randomPriorityArray = {1, 10, 5, 7, 9};
        int[] arr = {1, 2, 3, 4, 5};
        sortArrayUsingPriorityArrayAsSortKeys(arr, randomPriorityArray);
        SimpleUtil.printArr(arr);
    }

}

