package TopK;

import ElementarySort.AlgoUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/09/11:19
 * @Description
 */

public class MajEleCandidate {
    /**
     * 选择众数候选者
     * 递归版
     * @param arr
     * @return
     */
    public static int majEleCandidate(int[] arr,int lo, int hi,int majEleCandidate, int count) {
        if (lo>hi){
            return majEleCandidate;
        }
        if (count==0) {
            return majEleCandidate(arr,lo+1,hi,arr[lo],count+1);
        }else if (arr[lo]==majEleCandidate){
            return majEleCandidate(arr,lo+1,hi,majEleCandidate,count+1);
        }else {
            return majEleCandidate(arr,lo+1,hi,majEleCandidate,count-1);
        }
    }

    /**
     * 选择众数候选者 迭代版
     * @param arr
     * @return
     */
    public static int majEleCandidate(int[] arr) {
        int marEleCandidate = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                marEleCandidate = arr[i];
                count = count + 1;
            } else {
                if (marEleCandidate == arr[i]) {
                    count = count + 1;
                } else {
                    count = count - 1;
                }
            }
        }
        return marEleCandidate;
    }

    /**
     * 测试方法
     * @param maxTestTimes
     */
    public static void testForMajEleCandidate(int maxTestTimes){
        for (int i=0;i<maxTestTimes;i++){
          int[] arr= AlgoUtil.generateRandomArray(20,10);
          int marEleCandidate1=majEleCandidate(arr);
          int marEleCandidate2=majEleCandidate(arr,0,arr.length-1,arr[0],0);
          if (marEleCandidate1!=marEleCandidate2){
              System.out.println("Sorry test failed");
              break;
          }
        }
        System.out.println("Nice test passed");

    }

    public static void main(String[] args) {
//        int[] arr={3,3,5,5,5};
//        int result=majEleCandidate(arr,0,arr.length-1,arr[0],0);
//        int result2=majEleCandidate(arr);
//        System.out.println(result);
//        System.out.println(result2);
       // testForMajEleCandidate(1000);
    }

}
