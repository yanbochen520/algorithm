package DevideConquer;

import ElementarySort.AlgoUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/20/22:12
 * @Description
 */

public class FindMaximumSubarray {
    /**
     * 4.1-1 4.1-4
     * 递归法求解最大子数组问题
     *
     * @param arr
     * @param lo
     * @param hi
     * @return 当元素均为负数时，返回0
     */
    public static int findMaximumSubarray(int[] arr, int lo, int hi) {
        if (arr == null) {
            return 0;
        }
        if (lo == hi) {
            return arr[lo];
        }
        int mid = (lo + hi) / 2;
        int leftSum = findMaximumSubarray(arr, lo, mid);
        int rightSum = findMaximumSubarray(arr, mid + 1, hi);
        int crossSum = findMaximumCrossingSubarray(arr, lo, hi);
        return Math.max(Math.max(leftSum, rightSum), crossSum) <= 0 ? 0 : Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    /**
     * 跨中点元素的最大子数组
     *
     * @param arr
     * @param lo
     * @param hi
     * @return 当元素均为负数时，返回0
     */

    public static int findMaximumCrossingSubarray(int[] arr, int lo, int hi) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = (lo + hi) / 2;
        for (int i = mid; i >= lo; i--) {
            sum = sum + arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= hi; i++) {
            sum = sum + arr[i];
            if (sum > rightSum) {
                rightSum = sum;
            }

        }
        return leftSum + rightSum;
    }

    /**
     * 4.1-2
     * 暴力破解法求解最大子数组问题
     *
     * @param arr
     * @return 当元素均为负数时，返回0
     */
    public static int findMaximumSubarrayBF(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = Math.max(AlgoUtil.calculateSubarraySum(arr, i, j), sum);

            }
        }
        return sum <= 0 ? 0 : sum;
    }

    /**
     * 4.1-3
     * 测试递归和暴力破解二者性能的好坏
     * 判定递归胜出时，最小的输入规模
     *
     * @param maxScale
     */
    public static int determineMaxNWhenBFBetter(int maxScale) {
        int[] arr = AlgoUtil.generateRandomArray(maxScale, 5, -5);
        long startTime = System.currentTimeMillis();
        findMaximumSubarrayBF(arr);
        long endTime = System.currentTimeMillis();
        long runningTime = endTime - startTime;
        startTime = System.currentTimeMillis();
        findMaximumSubarray(arr, 0, arr.length - 1);
        endTime = System.currentTimeMillis();
        long runnningTime2 = endTime - startTime;
        if (runnningTime2 < runningTime) {
            return maxScale;
        }
        return -1;
    }

    public static void testForMaxScale(int maxScale) {
        for (int i = 1; i < maxScale; i++) {
            int result = determineMaxNWhenBFBetter(i);
            if (result != -1) {
                System.out.println(result);
                break;
            }
        }
    }

    /**
     * 4.1-5
     * 求解最大子数组问题
     * 非递归版本
     *
     * @param arr
     * @return 当元素均为负数时，返回0
     */
    public static int advancedFindMaximumSubarray(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int length = arr.length - 1;
        int sum = 0;
        while (length >= 0) {
            if (arr[length] >= 0) {
                sum = Math.max(sum, AlgoUtil.getMaxSumIncludedLastElement(arr, length));
            }
            length = length - 1;
        }
        return Math.max(sum, 0);
    }

    /**
     * 4.1-5
     * 求解最大子数组问题
     * 非递归版本
     *
     * @param arr
     * @return 当元素均为负数时，返回0
     */
    public static int advanced2FindMaximumSubarray(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                sum = Math.max(sum, AlgoUtil.getMaxSumIncludedLastElement(arr, i));
            }
        }
        return sum;
    }


    public static void testForFindMaximumSubarray(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = AlgoUtil.generateRandomArray(5, 5, -3);
            int resultByBF = findMaximumSubarrayBF(arr);
            int resultAdvanced = advanced2FindMaximumSubarray(arr);
            if (resultByBF != resultAdvanced) {
                AlgoUtil.printArr(arr);
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            testForMaxScale(10000);
        }
    }
}
