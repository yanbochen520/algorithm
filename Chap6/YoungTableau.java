package com.ums.algorithm.Chap6;
import com.ums.algorithm.Chap2.SimpleUtil;


/**
 * Created with IntelliJ IDEA.
 * @Auther: ybchen
 * @Date: 2020/03/03/11:25
 * @Description
 */

public class YoungTableau {
    /**
     * 6-2-c
     *
     * @param matrix
     * @return
     */
    public static int extractMin(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int min = matrix[0][0];
        matrix[0][0] = matrix[row - 1][column - 1];
        matrix[row - 1][column - 1] = Integer.MAX_VALUE;
        minHeapify(matrix, 0, 0);
        return min;
    }

    /**
     * 自下而上的下滤
     *
     * @param matrix
     * @param i
     * @param j
     */
    public static void minHeapify(int[][] matrix, int i, int j) {
        int row = matrix.length;
        int column = matrix[0].length;
        while (true) {
            int smallRow = i;
            int smallColumn = j;
            if (i + 1 < row && matrix[i + 1][j] < matrix[smallRow][smallColumn]) {
                smallRow = i + 1;
                smallColumn = j;
            }
            if (j + 1 < column && matrix[i][j + 1] < matrix[smallRow][smallColumn]) {
                smallRow = i;
                smallColumn = j + 1;
            }
            if (smallRow == i && smallColumn == j) {
                return;
            }
            SimpleUtil.swapInMatrix(matrix, i, j, smallRow, smallColumn);
            i = smallRow;
            j = smallColumn;
        }

    }

    /**
     * 6-2-d
     * @param maxtrix
     * @param key
     */
    public static void insertInYoungTableau(int[][] maxtrix, int key) {
        int row = maxtrix.length;
        int column = maxtrix[0].length;
        maxtrix[row - 1][column - 1] = key;
        maxHeapify(maxtrix, row - 1, column - 1);
    }

    public static void maxHeapify(int[][] matrix, int i, int j) {
        while (true) {
            int largestRow = i;
            int largestColumn = j;
            if (i - 1 >= 0 && matrix[i - 1][j] > matrix[largestRow][largestColumn]) {
                largestRow = i - 1;
                largestColumn = j;
            }
            if (j - 1 >= 0 && matrix[i][j - 1] >matrix[largestRow][largestColumn]) {
                largestRow = i;
                largestColumn = j - 1;
            }
            if (largestRow == i && largestColumn == j) {
                return;
            }
            SimpleUtil.swapInMatrix(matrix, i, j, largestRow, largestColumn);
            i = largestRow;
            j = largestColumn;
        }

    }


    /**
     * 判断某一个矩阵是否为杨氏矩阵
     *
     * @param matrix
     * @return
     */
    public static boolean isYoungTableau(int[][] matrix) {
        boolean flag = true;
        for (int i = 0; i < matrix.length; i++) {
            if (!SimpleUtil.isOrdered(matrix[i])) {
                flag = false;
            }
        }
        SimpleUtil.transformMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            if (!SimpleUtil.isOrdered(matrix[i])) {
                flag = false;
            }
        }
        SimpleUtil.transformMatrix(matrix);
        return flag;
    }

    /**
     * 利用杨氏矩阵对数组进行排序
     * 6-3-e
     * @param matrix
     * @return
     */
    public static int[] sortWithYoungTableau(int[][] matrix){
        int [] sortedArr=new int[matrix.length*matrix.length];
        for (int i=0;i<matrix.length*matrix.length;i++){
            sortedArr[i]=extractMin(matrix);
        }
        return  sortedArr;
    }

    /**
     * 查找算法O(M+N)
     * 6-2-f
     * @param matrix
     * @param target
     * @return
     */
    public static  boolean searchInYoungTableau(int [][] matrix,int target){
        int row=matrix.length-1;
        int column=0;
        while(row>=0&&column<=matrix[0].length-1){
            if (target==matrix[row][column]){
                return true;
            }else if (target>matrix[row][column]){
                column=column+1;
            }else{
                row=row-1;
            }
        }
        return  false;
    }


}
