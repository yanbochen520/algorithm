package  Chap2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/15/20:10
 * @Description
 */

public class InsertionSort {
    /**
     * @param arr :待排序数组
     */
    public static void insertionSort1(int[] arr,int lo,int hi) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = lo; i <= hi; i++) {
            for (int j = i - 1; j >= lo; j--) {
                if (arr[i] < arr[j]) {
                    SimpleUtil.swap(arr, i, j);
                    i = i - 1;
                }
            }
        }
    }

    /**
     * @param arr:待排序数组
     */
    private static void insertionSort2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int temp=arr[i];
            int j;
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }

    }


    public static void testForInsertionSort(int maxTestTimes) {
        for (int i = 0; i < maxTestTimes; i++) {
            int[] arr = SimpleUtil.generateRandomArray(5, 10);
            InsertionSort.insertionSort2(arr);
            boolean isOrdered = SimpleUtil.isOrdered(arr);
            if (!isOrdered) {
                SimpleUtil.printArr(arr);
                System.out.println("Sorry test failed");
                return;
            }
        }
        System.out.println("Nice test passed");

    }

    /**
     * 习题2.1-4
     *
     * @param arr1
     * @param arr2
     * @return
     */

    public static int[] calculateTwoBinaryIntegerSum(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + 1];
        int advanced = 0;
        for (int i = result.length - 1; i > 0; i--) {
            result[i] = (arr1[i - 1] + arr2[i - 1] + advanced) % 2;
            advanced = (arr1[i - 1] + arr2[i - 1] + advanced) / 2;
        }
        result[0] = advanced;
        return result;
    }




    public static void main(String[] args) {
       testForInsertionSort(1000);
//        int [] arr={1,9,5,4,8};
//        selectionSort(arr);
//       SimpleUtil.printArr(arr);
//        int[] arr1={1,0};
//        int[] arr2={1,1};
//        int[] result=calculateTwoBinaryIntegerSum(arr1,arr2);
//        SimpleUtil.printArr(result);
//        for (int i = 0; i < 1000; i++) {
//            int[] arr1 = SimpleUtil.generateRandomArray(6, 1);
//            int[] arr2 = SimpleUtil.generateRandomArray(6, 1);
//            int[] result = calculateTwoBinaryIntegerSum(arr1, arr2);
//            int convertResult = SimpleUtil.convertIntegerArray2IntegerNumber(result);
//            if (convertResult != SimpleUtil.convertIntegerArray2IntegerNumber(arr1) + SimpleUtil.convertIntegerArray2IntegerNumber(arr2)) {
//                System.out.println("Sorry test failed");
//                return;
//            }
//
//        }
//        System.out.println("Nice test passed");
//
        int[] arr={1,5,4};
        insertionSort2(arr);
        SimpleUtil.printArr(arr);

    }
}
