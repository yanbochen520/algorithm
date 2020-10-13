package RandomAlgorithm;

import ElementarySort.AlgoUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/29/10:02
 * @Description
 */

public class RandomInteger {
    /**
     * 5.1-3
     * 以同等概率生成 0和1
     *
     * @return
     */
    public static int randomZero2One() {
        while (true) {
            int a = biasedRandom();
            int b = biasedRandom();
            if (a != b) {
                return a;
            }
        }
    }

    /**
     * 以p的概率生成0,1-p的概率生成1
     *
     * @return
     */
    public static int biasedRandom() {
        double p = 0.8;
        return Math.random() > p ? 1 : 0;
    }

    /**
     * 5.1-3
     * 随机生成[a,b]的数
     *
     * @param a
     * @param b
     * @return
     */
    public static int random(int a, int b) {
        int sum;
        int count = 0;
        int c = Math.abs(b - a);
        while (c != 0) {
            c = c / 2;
            count = count + 1;
        }
        do {
            sum = 0;
            for (int i = 0; i < count; i++) {
                sum = sum + (int) ((Math.pow(2, i)) * randomZero2One());
            }
        } while (sum > (b - a));
        return a < b ? sum + a : sum + b;
    }

    public static void testForRandomA2B(int maxTestTimes, int a, int b) {
        int totalNumber = 0;
        int[] arr = new int[b - a + 1];
        for (int i = 0; i < maxTestTimes; i++) {
            int result = random(a, b);
            arr[result - a] = arr[result - a] + 1;
        }
        for (int j = 0; j < arr.length; j++) {
            totalNumber = totalNumber + arr[j];
        }
        if (totalNumber != maxTestTimes) {
            System.out.println("totalNumber is " + totalNumber);
            return;
        } else {
            AlgoUtil.printArr(arr);
        }
    }


    public static boolean testForRandomZero2One(int maxTestTimes) {
        int gap = 0;
        for (int i = 0; i < maxTestTimes; i++) {
            int result = randomZero2One();
            gap = result == 1 ? gap + 1 : gap - 1;
        }
        return Math.abs(gap) <= 200;
    }

    public static void main(String[] args) {
        testForRandomA2B(200, 3, 7);
//        for (int i = 0; i < 100; i++) {
//            System.out.println(random(3, 7));
//        }
//    }
    }
}