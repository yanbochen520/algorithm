package  Chap7;

import  Chap2.SimpleUtil;
import  Chap5.RandomInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/05/16:57
 * @Description
 */

public class MedianPartition {
    /**
     * 中位数切分快排
     * 7-5
     * @param arr
     * @param lo
     * @param hi
     */
    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arr, lo, hi);
            quickSort(arr, lo, pivot - 1);
            quickSort(arr, pivot + 1, hi);
        }
    }

    /**
     * 三个数中取中位数
     */
    public static int getMedian(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    /**
     * 选择候选轴点，并得到其下标
     * @param arr
     * @param lo
     * @param hi
     * @return
     */

    public static int choosePivot(int[] arr, int lo, int hi) {
        Map<Integer, Integer> integerMap = new HashMap<Integer, Integer>();
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            int j = getRandomElement(arr, lo, hi);
            integerMap.put(arr[j], j);
            temp[i] = arr[j];
        }
        return integerMap.get(getMedian(temp));
    }

    /**
     * 随机生成[a,b]中的一个数
     * @param arr
     * @param lo
     * @param hi
     * @return
     */

    public static int getRandomElement(int[] arr, int lo, int hi) {
        return RandomInteger.random(lo, hi);
    }

    /**
     * 中位数切分
     * @param arr
     * @param lo
     * @param hi
     * @return
     */

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = choosePivot(arr, lo, hi);
        SimpleUtil.swap(arr, hi, pivot);
        return QuickSort.partition3(arr, lo, hi);
    }

}
