package Heap;

import ElementarySort.AlgoUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/02/11:25
 * @Description
 */

public class BuildMaxHeap {
    /**
     * Floyd建堆算法O(N)
     * @param arr
     * @param heapSize
     */
    public static void buildMaxHeap(int[] arr, int heapSize) {
        for (int i = MaxHeapify.parent(heapSize - 1) + 1; i >= 0; i--) {
            MaxHeapify.maxHeapify2(arr, i, heapSize);
        }

    }

    public static void main(String[] args) {
        int[] arr={5,3,17,10,84,19,6,22,9};
        buildMaxHeap(arr,arr.length);
        AlgoUtil.printArr(arr);
    }
}
