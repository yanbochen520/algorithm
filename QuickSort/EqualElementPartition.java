package QuickSort;

import ElementarySort.AlgoUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/06/10:04
 * @Description
 */

public class EqualElementPartition {
    /**
     * 快速排序：O(NlgN)
     * @param arr
     * @param lo
     * @param hi
     */
    public static void equalElementQuickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int[] result = randomEqualElementPartition(arr, lo, hi);
            equalElementQuickSort(arr, lo, result[0] - 1);
            equalElementQuickSort(arr, result[1] + 1, hi);
        }
    }

    /**
     * 对有相同元素的切换算法
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int[] equalElementPartition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo - 1;//小于区域的右边界，包括在内
        int j = hi;//大于区域的左边界，包括在内
        for (int k = lo; k < j; k++) {
            if (arr[k] < pivot) {
                i = i + 1;
                AlgoUtil.swap(arr, i, k);
            } else if (arr[k] > pivot) {
                j = j - 1;
                AlgoUtil.swap(arr, k, j);
                k = k - 1;
            }
        }
        AlgoUtil.swap(arr, hi, j);//与大于的左边界交换
        return new int[]{i + 1, j};
    }
    /**
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int[] randomEqualElementPartition(int[] arr, int lo, int hi) {
        int pivot = MedianPartition.choosePivot(arr, lo, hi);
        AlgoUtil.swap(arr, pivot, hi);
        return equalElementPartition(arr, lo, hi);

    }



}
