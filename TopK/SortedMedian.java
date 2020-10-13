package TopK;

import ElementarySort.AlgoUtil;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/10/11:26
 * @Description
 */

public class SortedMedian {
    /**
     * 有序表的中位数
     * 9.3-8
     * @param arr1
     * @param lo1
     * @param arr2
     * @param lo2
     * @param length
     * @return
     */
    public static int sortedMedian(int[] arr1, int lo1, int[] arr2, int lo2, int length) {
        //base case 的选取
        if (length <= 2) {
            return trivialMedian(arr1, lo1, length, arr2, lo2, length);
        } else {
            int mid1 = lo1 + length / 2;
            int mid2 = (lo2) + (length - 1) / 2;
            if (arr1[mid1] < arr2[mid2]) {
                return sortedMedian(arr1, mid1, arr2, lo2, length + (lo1 - mid1));
            } else if (arr1[mid1] > arr2[mid2]) {
                return sortedMedian(arr1, lo1, arr2, mid2, length + (lo2 - mid2));
            } else {
                return arr1[mid1];
            }
        }
    }

    public static int trivialMedian(int[] arr1, int lo1, int len1, int[] arr2, int lo2, int len2) {
        int[] result = new int[len1 + len2];
        for (int i = 0; i < len1; i++) {
            result[i] = arr1[lo1++];
        }
        for (int i = len1; i < result.length; i++) {
            result[i] = arr2[lo2++];
        }
        return SelectUtil.median(result);
    }

    public static int sortedMedian(int[] arr1, int[] arr2) {
        return trivialMedian(arr1, 0, arr1.length, arr2, 0, arr2.length);
    }

    /**
     * 测试
     * @param maxTestTimes
     */
    public static void testForSortedMedian(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr1 = AlgoUtil.generateRandomArray(20, 40);
            arr1 = AlgoUtil.deduplicate(arr1);
            Arrays.sort(arr1);
            int[] arr2 = AlgoUtil.generateRandomArray(20, 40);
            arr2 = AlgoUtil.deduplicate(arr2);
            Arrays.sort(arr2);
            if (arr1.length == arr2.length) {
                int res1 = sortedMedian(arr1, 0, arr2, 0, arr2.length);
                int res2 = sortedMedian(arr1, arr2);
                if (res1 != res2) {
                    AlgoUtil.whenErrorOccur();
                    return;
                }
            }
        }
        AlgoUtil.whenSuccess();
    }

    public static void main(String[] args) {

    }


}
