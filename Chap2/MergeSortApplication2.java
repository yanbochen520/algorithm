package  Chap2;

import java.util.stream.StreamSupport;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/17/21:25
 * @Description
 */

public class MergeSortApplication2 {
    public int reversePairs(int[] nums) {
      return getTotalInversionPairNumbersByMergeSort(nums,0,nums.length-1);
    }
    /**
     * 2-4
     * 利用归并排序求解逆序数对，时间复杂度为O(NlgN)
     * @param arr
     * @param lo
     * @param hi
     * @return
     */

    public static int getTotalInversionPairNumbersByMergeSort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return 0;
        } else {
            return  getTotalInversionPairNumbersByMergeSort(arr, lo, (hi + lo) / 2) +
                    getTotalInversionPairNumbersByMergeSort(arr, (hi + lo) / 2 + 1, hi) +
                    mergeBySentinels(arr, lo, (lo + hi) / 2, hi);
        }
    }

    public static int mergeBySentinels(int[] arr, int lo, int mid, int hi) {
        int sum = 0;
        final int leftLength = mid - lo + 2;
        final int rightLength = hi - mid + 1;
        long[] left = new long[leftLength];
        long[] right = new long[rightLength];
        for (int i = 0; i < leftLength - 1; i++) {
            left[i] = arr[lo + i];
        }
        for (int i = 0; i < rightLength - 1; i++) {
            right[i] = arr[mid + 1 + i];
        }
        left[leftLength - 1]  = 9223372036854775806L;
        right[rightLength - 1] = 9223372036854775806L;
        int j = 0;
        int k = 0;
        for (int i = lo; i <= hi; i++) {
            if (left[j] <= right[k]) {
                arr[i] =(int) left[j];
                j = j + 1;
            } else {
                arr[i] =(int) right[k];
                k = k + 1;
                sum = sum + leftLength - 1 - j;
            }

        }
        return sum;
    }

    public static int getTotalInversionPairNumbers(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    result = result + 1;
                }
            }
        }
        return result;
    }

    public static void testForGetTotalInversionPairNumbersByMergeSort(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(5, 10);
            boolean flag = getTotalInversionPairNumbers(arr) == getTotalInversionPairNumbersByMergeSort(arr, 0, arr.length - 1);
            //boolean isOrdered = SimpleUtil.isOrdered(arr);
            if (!flag) {
                //SimpleUtil.printArr(arr);
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");
    }


    public static void main(String[] args) {
        int[] arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int result = getTotalInversionPairNumbersByMergeSort(arr, 0, arr.length - 1);
        System.out.println(result);
//int result=mergeBySentinels(arr,0,(0+arr.length-1)/2,arr.length-1);
        //System.out.println(result);
        //testForGetTotalInversionPairNumbersByMergeSort(800);
    }
}
