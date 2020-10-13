package Heap;

import ElementarySort.AlgoUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/02/9:51
 * @Description
 */

public class MaxHeapify {
    /**
     * i的左孩子的下标
     * @param i
     * @return
     */
    public static int leftChild(int i) {
        return i * 2 + 1;
    }

    /**
     * i的右孩子的下标
     * @param i
     * @return
     */
    public static int rightChild(int i) {
        return (i + 1) * 2;
    }

    /**
     * i的父亲的下标
     *
     * @param i
     * @return
     */
    public static int parent(int i) {
        return (i - 1) / 2;
    }

//    /**
//     * 维护大顶堆的性质，Floyd算法的主要步骤
//     * 尾递归版
//     *
//     * @param heap
//     * @param i:待下滤节点
//     * @param heapSize:堆的总大小
//     */
//    public static void maxHeapify(int[] heap, int i, int heapSize) {
//        int left = leftChild(i);
//        int right = rightChild(i);
//        int largest = i;
//        if (left < heapSize && heap[left] > heap[i]) {
//            largest = left;
//        }
//        if (right < heapSize && heap[right] > heap[largest]) {
//            largest = right;
//        }
//        if (largest == i) {
//            return;
//        } else {
//            AlgoUtil.swap(heap, i, largest);
//        }
//        maxHeapify(heap, largest, heapSize);
//    }

    /**
     * 维护大顶堆的性质，Floyd算法的主要步骤:
     * 循环迭代版
     * 6.2-5
     *
     * @param heap
     * @param i:待下滤节点
     * @param heapSize:堆的总大小
     */
    public static void maxHeapify2(int[] heap, int i, int heapSize) {
        while (true) {
            int left = leftChild(i);
            int right = rightChild(i);
            int largest = i;
            if (left < heapSize && heap[left] > heap[i]) {
                largest = left;
            }
            if (right < heapSize && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest == i) {
                return;
            } else {
                AlgoUtil.swap(heap, i, largest);
            }
            i = largest;
        }
    }

    public static void main(String[] args) {
        int[] heap = {27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
        maxHeapify2(heap, 2, heap.length);
        AlgoUtil.printArr(heap);
    }

}
