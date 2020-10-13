package TopK;

import ElementarySort.AlgoUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/09/14:34
 * @Description
 */

public class MaxAndMin {
    /**
     * 成对比较以找到最大最小值
     *
     * @param arr
     * @return
     */
    public static int[] findMaxMinSameTime(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i + 1] < min) {
                    min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
        }
        return new int[]{min, max};
    }

    /**
     * 暴力破解法 找到最大最小值
     * @param arr
     * @return
     */
    public static int[] findMaxMin(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(arr[i], min);
        }

        return new int[]{min, max};
    }

    /**
     * 测试方法
     *
     * @param maxTestTimes
     */
    public static void testForFindMaxMinSameTime(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = AlgoUtil.generateRandomArray(10, 10);
            int[] result1 = findMaxMinSameTime(arr);
            int[] result2 = findMaxMin(arr);
            boolean flag = AlgoUtil.isEqualArr(result1, result2);
            if (!flag) {
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");
    }

    public static void main(String[] args) {
        testForFindMaxMinSameTime(1000);
    }

}
