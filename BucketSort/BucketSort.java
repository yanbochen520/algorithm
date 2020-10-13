package BucketSort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/08/15:23
 * @Description
 */

public class BucketSort {
    /**
     * 桶排序
     * @param arr
     */
    public static void bucketSort(double[] arr) {
        int arrayLength = arr.length;
        int k=0;
        ArrayList<Double>[] bucket = new ArrayList[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            bucket[i] = new ArrayList<>();
        }
        for (int i = 0; i < arrayLength; i++) {
            bucket[(int) (arrayLength * arr[i])].add(arr[i]);
        }
        for (int i = 0; i < arrayLength; i++) {
            Collections.sort(bucket[i]);
        }
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                arr[k++] = bucket[i].get(j);
            }
        }
    }


}
