package QuickSort;

import ElementarySort.AlgoUtil;
import  RandomAlgorithm.RandomInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/05/10:33
 * @Description
 */

public class RandomQuickSort {
    /**
     * 随机快排
     * @param arr
     * @param lo
     * @param hi
     */
    public static void randomQuickSort(int[] arr,int lo,int hi){
        if (lo<hi){
            int pivot=randomPartition(arr,lo,hi);
            randomQuickSort(arr,lo,pivot-1);
            randomQuickSort(arr,pivot+1,hi);
        }

    }

    /**
     * 随机切分
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static  int  randomPartition(int[] arr,int lo,int hi){
           AlgoUtil.swap(arr,hi, RandomInteger.random(lo,hi));
           return QuickSort.partition2(arr,lo,hi);
    }

    /**
     *测试
     * @param maxTestTimes
     */
    public static void testForQuickSort(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = AlgoUtil.generateRandomArray(5, 10);
            randomQuickSort(arr, 0, arr.length - 1);
            if (!AlgoUtil.isOrdered(arr)) {
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");

    }

    public static void main(String[] args) {
        testForQuickSort(1000);
    }


}
