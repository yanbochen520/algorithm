package  Chap6;

import  Chap2.SimpleUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/02/15:42
 * @Description
 */

public class PriorityQueue {
    /**
     * 返回大顶堆中的最大元素
     *
     * @param heap
     * @return
     */
    public static int maximum(int[] heap) {
        return heap[0];
    }

    /**
     * 提取并从堆中最大元素。并维持堆序性
     * @param arr
     * @param heapSize
     * @return
     */
    public static int heapExtractMax(int[] arr, int heapSize) {
        int max = maximum(arr);
        arr[0] = arr[heapSize - 1];
        heapSize = heapSize - 1;
        MaxHeapify.maxHeapify2(arr, 0, heapSize);
        return max;
    }

    public static void heapInCreaseKey(int[] arr, int i, int key, int heapSize) throws IllegalArgumentException {
        if (key <= arr[i] || i > heapSize - 1) {
            throw new IllegalArgumentException("参数异常");
        }
        arr[i] = key;
        while (i > 0 && arr[i] > arr[MaxHeapify.parent(i)]) {
            SimpleUtil.swap(arr, i, MaxHeapify.parent(i));
            i = MaxHeapify.parent(i);
        }
    }

    /**
     * 插入算法
     * @param arr
     * @param key
     * @param heapSize
     */
    public static int[] maxHeapInsert(int[] arr, int key, int heapSize) {
        arr = SimpleUtil.copyArray(arr, 1);
        arr[heapSize] = Integer.MIN_VALUE;
        heapSize = heapSize + 1;
        heapInCreaseKey(arr, heapSize - 1, key, heapSize);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        arr= maxHeapInsert(arr,100,arr.length);
        SimpleUtil.printArr(arr);
    }

}
