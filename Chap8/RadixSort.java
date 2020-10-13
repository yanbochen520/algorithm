package  Chap8;

import  Chap2.SimpleUtil;


/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/06/15:14
 * @Description
 */

public class RadixSort {
    /**
     * 获取一个数字的位数
     * @param number
     * @return
     */
    public static int getBitsOfNumber(int number) {
        int res = 0;
        while (number != 0) {
            number = number / 10;
            res = res + 1;
        }
        return res;
    }

    /**
     * 获取一个数组中的最大的数字的位数，亦即数组的最大位数
     *
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int getMaxBitsInArray(int[] arr, int lo, int hi) {
        int maxElement = SimpleUtil.getMaxInArray(arr, lo, hi);
        return getBitsOfNumber(maxElement);
    }


    /**
     * 获取一个整数的第digital位
     * @param number
     * @param digital
     * @return
     */
    public static int getDigital(int number, int digital) {
        int result = 0;
        while (digital > 0) {
            result = number % 10;
            number = number / 10;
            digital = digital - 1;
        }
        return result;
    }

    /**
     * 获取arr[i]的第j位的数字
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int getIthElementJthDigital(int[] arr,int i, int j){

        return   getDigital(arr[i],j);
    }

    /**
     * 基数排序
     * @param arr
     * @param lo
     * @param hi
     */
    public static void radixSort(int[] arr, int lo, int hi) {
        int helpArrayLength = hi - lo + 1;//辅助数组的长度
        int[] help = new int[helpArrayLength];
        final int radix = 10;//基底
        int maxBits = getMaxBitsInArray(arr, lo, hi);
        for (int i = 1; i <= maxBits; i++) {
            int[] count = new int[radix];
            for (int j = lo; j <= hi; j++) {
                int result=getIthElementJthDigital(arr,j,i);
                count[result] = count[result] + 1;
            }
            for (int k = 1; k < count.length; k++) {
                count[k] = count[k] + count[k - 1];
            }
            for (int l = hi; l >= lo; l--) {
                int result=getIthElementJthDigital(arr,l,i);
                help[count[result] - 1]= arr[l];
                count[result] = count[result] - 1;
            }
            for (int m = 0; m < help.length; m++) {
                arr[lo + m] = help[m];//拷贝回原来的数组
            }
        }
    }

    /**
     * 测试
     * @param maxTestTimes
     */
    public static void testForRadixSort(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(10, 500, 100);
            radixSort(arr, 0, arr.length - 1);
            if (!SimpleUtil.isOrdered(arr)) {
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");
    }


    public static void main(String[] args) {
       testForRadixSort(900);
    }
}
