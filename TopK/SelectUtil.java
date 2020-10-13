package TopK;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * @Auther: ybchen
 * @Date: 2020/03/09/18:15
 * @Description 工具类
 */

public class SelectUtil {
    /**
     * 求中位数
     * @param arr
     * @return
     */
    public static int median(int [] arr){
        Arrays.sort(arr);
        return arr[(arr.length-1)/2];
    }
    public static int[] copyArray(int[] arr,int lo, int hi){
        int result []=new int[hi-lo+1];
        for (int i=0;i<result.length;i++){
            result[i]=arr[lo+i];
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
