package Heap;

import ElementarySort.AlgoUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/03/10:18
 * @Description
 */

public class DHeap {

    /**
     * 多叉堆的父节点
     * @param i
     * @param d
     * @return
     */
    public static int parent(int i, int d) {
        return (i - 1) / d;
    }

    /**
     * 维护d叉大顶堆的性质，Floyd算法的主要步骤:
     *
     * @param arr
     * @param k
     * @param i
     * @param heapSize
     * @return
     */

    public static void maxHeapify(int[] arr, int k, int i, int heapSize) {
        int largest = i;
        for (int j = 1; j < k + 1; j++) {
            if (heapSize > (k * i + j) && arr[k * i + j] > arr[largest]) {
                largest = k * i + j;
            }
        }
        if (largest != i) {
            AlgoUtil.swap(arr, i, largest);
        } else {
            return;
        }
        maxHeapify(arr, k, largest, heapSize);

    }

    /**
     * 提取并从d叉堆中删除最大元素并维持堆序性
     * 6-2-c
     * @param heap
     * @param heapSize
     * @return
     */
    public static int extractMax(int[] heap, int heapSize) {
        int max = PriorityQueue.maximum(heap);
        heap[0] = heap[heapSize - 1];
        heapSize = heapSize - 1;
        MaxHeapify.maxHeapify2(heap, 0, heapSize);
        return max;

    }

    /**
     * 对D叉堆的插入操作
     * 6-2-d
     * @param arr
     * @param key
     * @param heapSize
     * @return
     */
    public static int[] heapInsert(int[] arr, int key, int heapSize) {
        return PriorityQueue.maxHeapInsert(arr, key, heapSize);
    }

    /**
     * 6-2-e
     * @param arr
     * @param i
     * @param key
     * @param k
     * @param heapSize
     * @throws IllegalArgumentException
     */

    public static void heapInCreaseKey(int[] arr, int i, int key, int k, int heapSize) throws IllegalArgumentException {
        if (key <= arr[i]) {
            throw new IllegalArgumentException("参数异常");
        }
        arr[i] = key;
        while (i > 0 && arr[i] > arr[parent(i, k)]) {
            AlgoUtil.swap(arr, i, parent(i, k));
            i = parent(i, k);
        }
    }




}
