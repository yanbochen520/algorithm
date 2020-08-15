package com.ums.algorithm.Chap2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/16/15:22
 * @Description
 */

public class MergeSort {
    /**
     * 归并排序
     *
     * @param arr
     * @param lo
     * @param hi
     */
    public static void mergeSort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        } else {
            mergeSort(arr, lo, (lo + hi) / 2);
            mergeSort(arr, (lo + hi) / 2 + 1, hi);
            merge(arr, lo, (lo + hi) / 2, hi);
        }
    }

    /**
     * 2-1
     * 归并排序的优化，在小区间内使用插入排序，减少递归次数
     * @param arr
     * @param lo
     * @param hi
     * @param interval
     */
    public static void mergeSortUsingInsertionSortInSmallInterval(int[] arr, int lo, int hi, int interval) {
        if (lo >= hi) {
            return;
        }
        if (lo + interval == hi) {
            InsertionSort.insertionSort1(arr, lo, hi);
            return;
        } else {
            mergeSortUsingInsertionSortInSmallInterval(arr, lo, (lo + hi) / 2, interval);
            mergeSortUsingInsertionSortInSmallInterval(arr, (lo + hi) / 2 + 1, hi, interval);
            merge(arr, lo, (lo + hi) / 2, hi);
        }
    }


    /**
     * 2.3-3：不用哨兵进行merge的过程
     *
     * @param arr
     * @param lo
     * @param mid
     * @param hi
     */

    public static void merge(int[] arr, int lo, int mid, int hi) {
        final int leftLength = mid - lo + 1;
        final int rightLength = hi - mid;
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];
        for (int i = 0; i <= leftLength - 1; i++) {
            left[i] = arr[lo + i];
        }
        for (int i = 0; i <= rightLength - 1; i++) {
            right[i] = arr[mid + 1 + i];
        }
        int j = 0;
        int k = 0;
        for (int i = lo; i <= hi; i++) {
            if (k < rightLength && j < leftLength && left[j] < right[k]) {
                arr[i] = left[j];
                j = j + 1;
            } else if (j < leftLength && k < rightLength && left[j] >= right[k]) {
                arr[i] = right[k];
                k = k + 1;
            } else if (j >= leftLength) {
                arr[i] = right[k];
            } else if (k >= rightLength) {
                arr[i] = left[j];
            }
        }

    }

    /**
     * 将arr[i]插入到已经有序数组的合适位置，使新数组整体有序
     *
     * @param arr
     * @param i
     */
    public static void insertInRightPlace(int[] arr, int i) {
        int temp = arr[i];
        int j;
        for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
            arr[j + 1] = arr[j];
        }
        arr[j + 1] = temp;
    }

    /**
     * 2.3-6
     * 利用二分查找,将arr[i]插入到已经有序的数组的合适位置,使新数组整体亦有序
     * 此方法虽然提高了查找的而效率，但是插入排序的复杂度并未改变。
     */
    public static void insertInRightPlaceByBinarySearch(int[] arr, int i) {
        int target = arr[i];
        int index = BinarySearch.binarySearch(arr, target, 0, i - 1);
        int j = i;
        for (; j > index + 1; j--) {
            arr[j] = arr[j - 1];
        }
        arr[j] = target;

    }


    /**
     * 引入哨兵元素进行merge 代码实现更简单
     *
     * @param arr
     * @param lo
     * @param mid
     * @param hi
     */
    public static void mergeBySentinels(int[] arr, int lo, int mid, int hi) {
        final int leftLength = mid - lo + 2;
        final int rightLength = hi - mid + 1;
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];
        for (int i = 0; i < leftLength - 1; i++) {
            left[i] = arr[lo + i];
        }
        for (int i = 0; i < rightLength - 1; i++) {
            right[i] = arr[mid + 1 + i];
        }
        left[leftLength - 1] = Integer.MAX_VALUE;
        right[rightLength - 1] = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        for (int i = lo; i <= hi; i++) {
            if (left[j] < right[k]) {
                arr[i] = left[j];
                j = j + 1;
            } else {
                arr[i] = right[k];
                k = k + 1;
            }

        }
    }

    public static void testForInsertionSort(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(5, 10);
            MergeSort.mergeSort(arr, 0, arr.length - 1);
            //MergeSort.insertionSort(arr,0,arr.length-1);
            insertionSort(arr, 0, arr.length - 1);
            boolean isOrdered = SimpleUtil.isOrdered(arr);
            if (!isOrdered) {
                SimpleUtil.printArr(arr);
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");

    }

    public static void testForMergeSort(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(10, 10);
            mergeSortUsingInsertionSortInSmallInterval(arr, 0, arr.length - 1, 3);
            boolean isOrdered = SimpleUtil.isOrdered(arr);
            if (!isOrdered) {
                SimpleUtil.printArr(arr);
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");

    }


    /**
     * 2.3-4
     * 递归版本的插入排序：复杂度为O(n^2)
     *
     * @param arr
     * @param lo
     * @param hi
     */
    public static void insertionSort(int[] arr, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        insertionSort(arr, lo, hi - 1);
        insertInRightPlaceByBinarySearch(arr, hi);

    }

    public static void main(String[] args) {
        testForMergeSort(1000);
    }


}
