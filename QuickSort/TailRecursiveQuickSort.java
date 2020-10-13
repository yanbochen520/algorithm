package QuickSort;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/05/16:33
 * @Description
 */

public class TailRecursiveQuickSort {
    /**
     * 7-4
     * 消除尾递归
     * @param arr
     * @param lo
     * @param hi
     */
    public static void quickSort(int[] arr, int lo, int hi) {
        while(true) {
            if (lo>=hi){
                break;
            }
            int pivot = QuickSort.partition2(arr, lo, hi);
            quickSort(arr, lo, pivot - 1);
            lo=pivot+1;
        }

    }

}
