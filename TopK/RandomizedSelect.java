package TopK;

import ElementarySort.AlgoUtil;
import  RandomAlgorithm.RandomInteger;
import  RandomAlgorithm.SearchMethod;
import  QuickSort.QuickSort;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static  QuickSort.MedianPartition.partition;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/09/15:14
 * @Description
 */

public class RandomizedSelect {
    /**
     * TOP K 问题
     * 在lo-hi的区间内找到第K大的数，
     * k=1,2,3,.......（hi-lo+1）
     *
     * @param arr
     * @param lo
     * @param hi
     * @param i
     * @return
     */
    /*public static int randomizedSelect(int[] arr,int lo,int hi, int i){
        if (i<1){
            throw new IllegalArgumentException("参数不合法");
        }
        if (lo>=hi){
            return  arr[lo];
        }else{
            int pivotIndex=QuickSort.partition2(arr,lo,hi);
            int leftNumber=pivotIndex-lo+1;
            if (leftNumber==i){
                return arr[pivotIndex];
            }else if (leftNumber>i){
                return randomizedSelect(arr,lo,pivotIndex-1,i);
            }else{
                return randomizedSelect(arr,pivotIndex+1,hi,i-leftNumber);
            }
        }
    }*/
    public static int randomizedSelect(int[] arr, int lo, int hi, int k) {
        while (true) {
            int pivot = partition(arr, lo, hi);
            if (pivot == k - 1) {
                return arr[pivot];
            } else if (pivot > k - 1) {
                hi = pivot - 1;
            } else {
                lo = pivot + 1;
            }
        }
    }

    public static int selectBruteForce(int[] arr, int i) {
        Arrays.sort(arr);
        return arr[i - 1];
    }

    public static void testForRandomizedSelect(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = AlgoUtil.generateRandomArray(100, 20);
            int randomInteger = RandomInteger.random(1, arr.length);
            int result = randomizedSelect(arr, 0, arr.length - 1, randomInteger);
            int result1 = selectBruteForce(arr, randomInteger);
            if (result != result1) {
                AlgoUtil.whenErrorOccur();
                return;
            }
        }
        AlgoUtil.whenSuccess();
    }

    /**
     * 最坏情况下为线性时间的查找
     *
     * @param arr
     * @param lo
     * @param hi
     * @param i
     * @return
     */
    public static int linearSelect(int[] arr, int lo, int hi, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("参数不合法");
        }
        if (lo == hi) {
            return arr[lo];// base case
        }
        int arrayLength = hi - lo + 1;
        int subArrayNumbers = (int) Math.ceil(arrayLength / 5.0) - 1;
        int[] subMedianArrays = new int[subArrayNumbers + 1];
        int j = 0;
        int start = lo;
        int end = hi;
        while (subArrayNumbers > 0) {
            int[] subArray = SelectUtil.copyArray(arr, start, start + 4);
            start = start + 5;
            subMedianArrays[j++] = SelectUtil.median(subArray);
            subArrayNumbers = subArrayNumbers - 1;
        }
        if (start <= end) {
            int[] appendSubArray = SelectUtil.copyArray(arr, start, end);
            subMedianArrays[subMedianArrays.length - 1] = SelectUtil.median(appendSubArray);
        }
        int subMedianArraysMedian = linearSelect(subMedianArrays, 0, subMedianArrays.length - 1, (subMedianArrays.length - 1) / 2 + 1);
        int subMedianArraysMedianIndex = SearchMethod.deterministicSearch(arr, subMedianArraysMedian);
        AlgoUtil.swap(arr, hi, subMedianArraysMedianIndex);
        int pivotIndex = QuickSort.partition2(arr, lo, hi);
        //int leftNumber=pivotIndex-lo+1;
        if (pivotIndex == i - 1) {
            return arr[pivotIndex];
        } else if (pivotIndex > i - 1) {
            return linearSelect(arr, lo, pivotIndex - 1, i);
        } else {
            return linearSelect(arr, pivotIndex + 1, hi, i);
        }

    }

    public static char firstUniqChar(String s) {
        if (s == null) {
            return ' ';
        }
        Map<Character, Integer> map = new LinkedHashMap();
        char[] strCharArr = s.toCharArray();
        for (int i = 0; i < strCharArr.length; i++) {
            if (!map.containsKey(strCharArr[i])) {
                map.put(strCharArr[i], 1);
            } else {
                int count = map.get(strCharArr[i]);
                map.put(strCharArr[i], count + 1);
            }
        }
        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void testForLinearSelect(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = AlgoUtil.generateRandomArray(7, 20);
            arr = AlgoUtil.deduplicate(arr);
            AlgoUtil.printArr(arr);
            int randomInteger = RandomInteger.random(1, arr.length);
            int result = linearSelect(arr, 0, arr.length - 1, randomInteger);
            int result1 = randomizedSelect(arr, 0, arr.length - 1, randomInteger);
            if (result != result1) {
                AlgoUtil.whenErrorOccur();
                return;
            }
        }
        AlgoUtil.whenSuccess();
    }


    public static void main(String[] args) {

        //firstUniqChar(str);
//      int [] arr={1,16,13,17};
//      int result2=linearSelect(arr,0,arr.length-1,3);
//      System.out.println(result2);
//       testForRandomizedSelect(1000);
        // testForLinearSelect(1000);
        //testForRandomizedSelect(1000);
//        int[] arr={10,4543634,5345,346,888,999,8568,6798,634634,654674};
//        int res=randomizedSelect(arr,3,6,2);
//        System.out.println(res);
//        int[] arr={5,4,3,2,1};
//        int res=randomizedSelect(arr,0,arr.length-1,arr.length-1);
//     System.out.println(res);
//        Map<Character,Integer> map=new HashMap();
//       for(Character c:map.keySet()){
//           if(map.get(c)==1){
//               return c;
//           }
//       }
//    }
    }
}