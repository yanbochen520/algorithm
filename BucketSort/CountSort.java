package BucketSort;

import ElementarySort.AlgoUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/06/10:59
 * @Description
 */

public class CountSort {
    /**
     * 计数排序，复杂度O(N)
     * @param arr
     * @param lo
     * @param hi
     */
    public static void countSort(int[] arr, int lo, int hi) {
        int countArrayLength = AlgoUtil.getMaxInArray(arr, lo, hi) + 1;
        int helpArrayLength = hi - lo + 1;
        int[] help = new int[helpArrayLength];
        int[] count = new int[countArrayLength];//词频统计数组
        for (int i = lo; i <= hi; i++) {
            count[arr[i]] = count[arr[i]] + 1;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];//count[i]代表小于等于arr[i]的元素的个数
        }
        for (int i = lo; i <= hi; i++) {
            help[count[arr[i]] - 1] = arr[i];
            count[arr[i]] = count[arr[i]] - 1;
        }
        for (int i = 0; i < help.length; i++) {
            arr[lo + i] = help[i];//拷贝回原来的数组
        }
    }

    /**
     * 测试
     * @param maxTestTimes
     */
    public static void testForCountSort(int maxTestTimes){
        for (int i=0;i<maxTestTimes;i++){
            int[] arr=AlgoUtil.generateRandomArray(10,20);
            countSort(arr,0,arr.length-1);
            boolean flag=AlgoUtil.isOrdered(arr);
            if (!flag){
                System.out.println("Sorry test failed");
                return ;
            }
        }
        System.out.println("Nice test passed");

    }

    public static void main(String[] args) {
        testForCountSort(10000);
    }
}
