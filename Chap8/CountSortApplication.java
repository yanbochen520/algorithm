package  Chap8;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/07/16:59
 * @Description
 */

public class CountSortApplication {
    /**
     * arr中在[a,b]的元素的个数
     * 8.2-4
     * @param arr
     * @param a
     * @param b
     * @return
     */
    public static int numberIntervalAB(int[] arr, int a, int b) {
        int sum = 0;
        int[] count = new int[b + 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= b) {
                count[arr[i]] = count[arr[i]] + 1;
            }
        }
        for (int i = a; i <= b; i++) {
             sum = sum + count[i];
        }
        return sum;
    }


}
