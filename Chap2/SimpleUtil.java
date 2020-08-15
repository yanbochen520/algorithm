package com.ums.algorithm.Chap2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/15/20:25
 * @Description
 */

public class SimpleUtil {
    /**
     * 将二进制数组转为对应的十进制数字
     *
     * @param arr
     * @return
     */
    public static int convertIntegerArray2IntegerNumber(int[] arr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            stringBuffer.append(arr[i]);
        }
        return Integer.parseInt(stringBuffer.toString(), 2);
    }

    /**
     * 遍历数组
     *
     * @param arr
     */
    public static void printArr(int[] arr) {
        for (int a : arr) {
            System.out.println(a);
        }
        System.out.println();
    }
    public static void printArr(double[] arr) {
        for (double a : arr) {
            System.out.println(a);
        }
        System.out.println();
    }

    /**
     * 打印一个二维数组
     * @param matrix
     */

    public static void printMatrix(int[][] matrix) {
        int row = matrix.length;
        for (int i = 0; i < row; i++) {
            printArr(matrix[i]);
        }

    }

    /**
     * 生成随机数组
     *
     * @param length：数组长度
     * @param maxValue：数组值介于[0,maxValue]
     * @return
     */
    public static int[] generateRandomArray(int length, int maxValue) {
        int[] arr = new int[length];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(maxValue) + 1;
        }
        return arr;
    }

    /**
     * 产生随机数组
     * @param length：数组长度
     * @param maxValue：数组中的最大值
     * @param minValue：数组中的最小值
     * @return
     */
    public static int[] generateRandomArray(int length, int maxValue, int minValue) {
        int[] arr = new int[length];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(maxValue - minValue) + minValue;
        }
        return arr;
    }

    /**
     * 测试数组是否有序
     */
    public static Boolean isOrdered(int[] arr) {
        boolean isOrdered = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                isOrdered = false;
                break;
            }
        }
        return isOrdered;
    }

    /**
     * 交换数组元素
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 数组去重
     *
     * @param arr
     * @return
     */
    public static int[] deduplicate(int[] arr) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!arrayList.contains(arr[i])) {
                arrayList.add(arr[i]);
            }
        }
        arr = new int[arrayList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    /**
     * 求子数组的最大和
     *
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int calculateSubarraySum(int[] arr, int lo, int hi) {
        int sum = 0;
        for (int i = lo; i <= hi; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    /**
     * 求包含下标为lastIndex元素子数组的最大和
     *
     * @param arr
     * @param lastIndex
     * @return
     */

    public static int getMaxSumIncludedLastElement(int[] arr, int lastIndex) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = lastIndex; i >= 0; i--) {
            sum = sum + arr[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    /**
     * 确保两个矩阵的可乘性
     *
     * @param matrixA
     * @param matrixB
     * @throws IllegalArgumentException
     */
    public static boolean ensureMatrixCanMultiply(int[][] matrixA, int[][] matrixB) throws IllegalArgumentException {
        return matrixA[0].length == matrixB.length;

    }

    /**
     * 判断一个矩阵是否是方阵
     *
     * @param matrix
     * @return
     */

    public static boolean isSquareMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        if (row != column) {
            return false;
        }
        return isPowerof2(row);//此时row==column,所以选其一进行判断即可
    }

    /**
     * 判断一个数是否是2的n次方
     * 递归版
     *
     * @param number
     * @return
     */

    public static boolean isPowerof2(int number) {
        int sum = 1;
        while (sum < number) {
            sum = sum * 2;
        }
        return sum == number;
    }

    /**
     * 判断一个数是否是2的n次方
     * 迭代版
     *
     * @param number
     * @return
     */


    /**
     * 判断两个矩阵是否同为方阵，并且可以相乘
     *
     * @param matrixA
     * @param matrixB
     * @return
     */
    public static boolean isSquareMatrixAndCanMultiply(int[][] matrixA, int[][] matrixB) {

        return isSquareMatrix(matrixA) && isSquareMatrix(matrixB) && ensureMatrixCanMultiply(matrixA, matrixB);
    }


    /**
     * 由一个大矩阵生成若干个小矩阵
     *
     * @param matrix
     * @param startRow
     * @param startColumn
     * @return
     */

    public static int[][] copySubMatrixForMasterMatrix(int[][] matrix, int startRow, int startColumn) {
        int N = matrix.length;
        int[][] result = new int[N / 2][N / 2];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                result[i][j] = matrix[i + startRow][j + startColumn];
            }
        }
        return result;
    }

    /**
     * 两矩阵相加
     *
     * @param matrixA
     * @param matrixB
     * @return
     */
    public static int[][] SumofMatrix(int[][] matrixA, int[][] matrixB) {
        int[][] result = new int[matrixA.length][matrixA[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    /**
     * 两矩阵相减
     *
     * @param matrixA
     * @param matrixB
     * @return
     */
    public static int[][] minusofMatrix(int[][] matrixA, int[][] matrixB) {
        int[][] result = new int[matrixA.length][matrixA[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return result;
    }

    /**
     * 将小矩阵逐一拷贝到大矩阵中，形成最后的大矩阵
     *
     * @param subMatrix
     * @param masterMatrix
     * @return
     */
    public static int[][] SubMatrix2MasterMatirx(int[][] subMatrix, int[][] masterMatrix, int startRow, int startColumn) {
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix[0].length; j++) {
                masterMatrix[i + startRow][j + startColumn] = subMatrix[i][j];
            }
        }

        return masterMatrix;
    }

    /**
     * 产生规模为scale*scale的随机矩阵
     *
     * @param scale
     * @return
     */
    public static int[][] generateRandomMatrix(int scale) {
        int[][] result = new int[scale][scale];
        Random random = new Random();
        for (int i = 0; i < scale; i++) {
            for (int j = 0; j < scale; j++) {
                int element = random.nextInt(10) + 1;
                result[i][j] = element;
            }
        }
        return result;

    }

    /**
     * 判断两个矩阵是否相等
     *
     * @param matrixA
     * @param matrixB
     * @return
     */

    public static boolean isEqualMatrix(int[][] matrixA, int[][] matrixB) {
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            return false;
        }
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 寻找子数组中的最小值
     *
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int findMinIndex(int[] arr, int lo, int hi) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = lo; i <= hi; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * 判断两个数组中各元素是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqualArr(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param src
     * @param rebound
     * @return
     */
    public static int[] copyArray(int[] src, int rebound) {
        int[] dest = new int[src.length + rebound];
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
        return dest;
    }

    /**
     * 交换矩阵中的两个元素
     *
     * @param i
     * @param j
     * @param l
     * @param m
     * @param matrix
     */
    public static void swapInMatrix(int[][] matrix, int i, int j, int l, int m) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[l][m];
        matrix[l][m] = temp;
    }

    /**
     * 求一个矩阵的转置矩阵
     *
     * @param matrix
     */
    public static void transformMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                swapInMatrix(matrix, i, j, j, i);
            }
        }
    }

    public static int[] generateOrderedArr(int initialNumber,int scale){
        int[] arr=new int[scale];
        for (int i=0;i<arr.length;i++){
            arr[i]=initialNumber+i;
        }
     return arr;
    }

    /**
     * 生成一个杨氏矩阵
     * @param initialNumber
     * @param scale
     * @return
     */
    public  static int[][] generateYoungTableau(int initialNumber,int scale){
        int[][] matrix=new int[scale][scale];
        for (int i=0;i<scale;i++){
            matrix[i]=generateOrderedArr(initialNumber+i,scale);
        }
       return matrix;
    }

    /**
     * 求arr[lo...hi]的最大值
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int getMaxInArray(int[] arr, int lo, int hi) {
        int max = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public static void whenErrorOccur(){
        System.out.println("Sorry test failed");

    }
    public static  void whenSuccess(){
        System.out.println("Nice test passed");

    }

//    /**
//     * 生成元素互异的数组
//     * @param length
//     * @param maxValue
//     * @return
//     */
//    public static int[] generateUniqueElementArray(int length ,int maxValue){
//        int[] result= generateRandomArray(length,maxValue);
//        return deduplicate(result);
//
//    }
public static int cuttingRope(int n) {
    if (n < 2)
        return 0;
    if (n == 2)
        return 1;
    if (n == 3)
        return 2;
    BigInteger[] dp = new BigInteger[n + 1];
    dp[1] = new BigInteger("1");//内循环中会用到这个值
    dp[2] = new BigInteger("2");
     dp[3] = new BigInteger("3");
    for (int i = 4; i <= n; i++) {
        dp[i] = new BigInteger("0");
        for (int L = 1; L < 4; L++) {
            dp[i] = dp[i].max(new BigInteger((L * (i - L)) + "").max(new BigInteger(L + "").multiply(dp[i - L])));
        }
    }
    return dp[n].mod(new BigInteger("1000000007")).intValue();
}
    public static void main(String[] args) {
//int[][] matrix={{}};
        System.out.println(cuttingRope(120));
        //int a=953271190;


    }
}
