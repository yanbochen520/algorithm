package QuickSort;

import ElementarySort.AlgoUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/03/17:30
 * @Description
 */

public class QuickSort {
    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition2(arr, lo, hi);
            quickSort(arr, lo, pivot - 1);
            quickSort(arr, pivot + 1, hi);
        }
    }

    /**
     * 快速切分算法
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int partition2(int[] arr, int lo, int hi) {
        int pivot = arr[hi];//主元
        int i = lo - 1;
        for (int j = lo; j <hi; j++) {
            if (arr[j] <= pivot) {
                i = i + 1;
                AlgoUtil.swap(arr, i, j);
            }
        }
        AlgoUtil.swap(arr,hi,i+1);
        return  i+1;
    }
    /**
     * 7.1-2
     * 快速切分算法
     * 能较好的应对全为重复元素的退化情况
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
//    public static int partition(int[] arr, int lo, int hi) {
//        int pivot = arr[hi];
//        while (lo < hi) {
//            while (lo < hi) {
//                if (arr[lo]<pivot) {
//                    lo = lo + 1;
//                }
//                else {
//                    arr[hi] = arr[lo];
//                    hi = hi - 1;
//                    break;
//                }
//            }
//            while (lo < hi ) {
//                if (arr[lo]>pivot) {
//                    hi = hi - 1;
//                }
//                else{
//                    arr[lo] = arr[hi];
//                    lo = lo + 1;
//                    break;
//                }
//            }
//        }
//        arr[hi] = pivot;
//        return lo;
//    }
    /**
     * 7.1-2
     * 快速切分算法
     * 能较好的应对全为重复元素的退化情况
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int partition3(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        while (lo < hi) {
            while (lo < hi && arr[lo] < pivot) {
                lo = lo + 1;
            }
            if (lo < hi && arr[lo] >= pivot) {
                arr[hi] = arr[lo];
                hi = hi - 1;
            }
            while (lo < hi && arr[hi] > pivot) {
                    hi = hi - 1;
                }
                if (lo < hi && arr[hi] <= pivot) {
                    arr[lo] = arr[hi];
                    lo = lo + 1;
                }
            }
        arr[hi] = pivot;
        return lo;
    }

    /**
     * 测试
     * @param maxTestTimes
     */
    public static void testForQuickSort(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = AlgoUtil.generateRandomArray(5, 10);
            quickSort(arr, 0, arr.length - 1);
            if (!AlgoUtil.isOrdered(arr)) {
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");

    }

    public static void main(String[] args) {
       // testForQuickSort(100);
        int[] arr={10,4543634,5345,346,57,567,8568,6798,634634,654674};
        int res=partition2(arr,5,arr.length-1);
        //AlgoUtil.printArr(arr);
      System.out.println(res);
    }

}
