package  Chap4;

import  Chap2.SimpleUtil;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/02/21/14:43
 * @Description
 */

public class SquareMatrixMultiply {
    /**
     * 暴力破解法求解矩阵相乘复杂度为O(N^3)
     *
     * @param matrixA
     * @param maxtrixB
     * @return
     * @throws IllegalArgumentException
     */
    public static int[][] squareMatrixMultiply(int[][] matrixA, int[][] maxtrixB) throws IllegalArgumentException {
        boolean isCanMultiply = SimpleUtil.ensureMatrixCanMultiply(matrixA, maxtrixB);
        if (isCanMultiply) {
            int row = matrixA.length;
            int column = maxtrixB[0].length;
            int[][] result = new int[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    for (int k = 0; k < matrixA[0].length; k++)
                        result[i][j] = result[i][j] + matrixA[i][k] * maxtrixB[k][j];
                }
            }
            return result;
        } else {
            throw new IllegalArgumentException("矩阵大小不合法,无法相乘");
        }
    }

    /**
     * 递归版本的矩阵相乘运算，复杂度仍然为O(N^3)
     *
     * @param matrixA
     * @param matrixB
     * @return
     * @throws IllegalArgumentException
     */

    public static int[][] advancedSquareMatrixMultiply(int[][] matrixA, int[][] matrixB) throws IllegalArgumentException {
        boolean canMultiply = SimpleUtil.isSquareMatrixAndCanMultiply(matrixA, matrixB);
        if (canMultiply) {
            int[][] matrixC = new int[matrixA.length][matrixB.length];
            if (matrixC.length == 1) {
                matrixC[0][0] = matrixA[0][0] * matrixB[0][0];
                return matrixC;
            }
            int[][] matrixA1, matrixA2, matrixA3, matrixA4, matrixB1, matrixB2, matrixB3, matrixB4, matrixC1, matrixC2, matrixC3, matrixC4;
            matrixA1 = SimpleUtil.copySubMatrixForMasterMatrix(matrixA, 0, 0);
            matrixA2 = SimpleUtil.copySubMatrixForMasterMatrix(matrixA, 0, matrixA.length / 2);
            matrixA3 = SimpleUtil.copySubMatrixForMasterMatrix(matrixA, matrixA.length / 2, 0);
            matrixA4 = SimpleUtil.copySubMatrixForMasterMatrix(matrixA, matrixA.length / 2, matrixA.length / 2);
            matrixB1 = SimpleUtil.copySubMatrixForMasterMatrix(matrixB, 0, 0);
            matrixB2 = SimpleUtil.copySubMatrixForMasterMatrix(matrixB, 0, matrixB.length / 2);
            matrixB3 = SimpleUtil.copySubMatrixForMasterMatrix(matrixB, matrixB.length / 2, 0);
            matrixB4 = SimpleUtil.copySubMatrixForMasterMatrix(matrixB, matrixB.length / 2, matrixB.length / 2);
            matrixC1 = SimpleUtil.SumofMatrix(advancedSquareMatrixMultiply(matrixA1, matrixB1), advancedSquareMatrixMultiply(matrixA2, matrixB3));
            matrixC2 = SimpleUtil.SumofMatrix(advancedSquareMatrixMultiply(matrixA1, matrixB2), advancedSquareMatrixMultiply(matrixA2, matrixB4));
            matrixC3 = SimpleUtil.SumofMatrix(advancedSquareMatrixMultiply(matrixA3, matrixB1), advancedSquareMatrixMultiply(matrixA4, matrixB3));
            matrixC4 = SimpleUtil.SumofMatrix(advancedSquareMatrixMultiply(matrixA3, matrixB2), advancedSquareMatrixMultiply(matrixA4, matrixB4));
            matrixC = SimpleUtil.SubMatrix2MasterMatirx(matrixC1, matrixC, 0, 0);
            matrixC = SimpleUtil.SubMatrix2MasterMatirx(matrixC2, matrixC, 0, matrixC.length / 2);
            matrixC = SimpleUtil.SubMatrix2MasterMatirx(matrixC3, matrixC, matrixC.length / 2, 0);
            matrixC = SimpleUtil.SubMatrix2MasterMatirx(matrixC4, matrixC, matrixC.length / 2, matrixC.length / 2);
            return matrixC;
        } else {
            throw new IllegalArgumentException("矩阵大小不合法,无法相乘");
        }
    }

    /**
     * 4.2-3
     * Strassen Method 矩阵相乘复杂度为O(N^lg7)
     * @param matrixA
     * @param matrixB
     * @return
     * @throws IllegalArgumentException
     */

    public static int[][] strassenMethodForMatrixMultiply(int[][] matrixA, int[][] matrixB) throws IllegalArgumentException {
        boolean canMultiply = SimpleUtil.isSquareMatrixAndCanMultiply(matrixA, matrixB);
        if (canMultiply) {
            int[][] matrixC = new int[matrixA.length][matrixB.length];
            if (matrixC.length == 1) {
                matrixC[0][0] = matrixA[0][0] * matrixB[0][0];
                return matrixC;
            }
            int[][] S1, S2, S3, S4, S5, S6, S7, S8, S9, S10,
                    P1, P2, P3, P4, P5, P6, P7,
                    matrixA11, matrixA12, matrixA21, matrixA22, matrixB11, matrixB12, matrixB21, matrixB22, matrixC11, matrixC12, matrixC21, matrixC22;
            matrixA11 = SimpleUtil.copySubMatrixForMasterMatrix(matrixA, 0, 0);
            matrixA12 = SimpleUtil.copySubMatrixForMasterMatrix(matrixA, 0, matrixA.length / 2);
            matrixA21 = SimpleUtil.copySubMatrixForMasterMatrix(matrixA, matrixA.length / 2, 0);
            matrixA22 = SimpleUtil.copySubMatrixForMasterMatrix(matrixA, matrixA.length / 2, matrixA.length / 2);
            matrixB11 = SimpleUtil.copySubMatrixForMasterMatrix(matrixB, 0, 0);
            matrixB12 = SimpleUtil.copySubMatrixForMasterMatrix(matrixB, 0, matrixB.length / 2);
            matrixB21 = SimpleUtil.copySubMatrixForMasterMatrix(matrixB, matrixB.length / 2, 0);
            matrixB22 = SimpleUtil.copySubMatrixForMasterMatrix(matrixB, matrixB.length / 2, matrixB.length / 2);
            S1 = SimpleUtil.minusofMatrix(matrixB12, matrixB22);
            S2 = SimpleUtil.SumofMatrix(matrixA11, matrixA12);
            S3 = SimpleUtil.SumofMatrix(matrixA21, matrixA22);
            S4 = SimpleUtil.minusofMatrix(matrixB21, matrixB11);
            S5 = SimpleUtil.SumofMatrix(matrixA11, matrixA22);
            S6 = SimpleUtil.SumofMatrix(matrixB11, matrixB22);
            S7 = SimpleUtil.minusofMatrix(matrixA12, matrixA22);
            S8 = SimpleUtil.SumofMatrix(matrixB21, matrixB22);
            S9 = SimpleUtil.minusofMatrix(matrixA11, matrixA21);
            S10 = SimpleUtil.SumofMatrix(matrixB11, matrixB12);
            P1 = strassenMethodForMatrixMultiply(matrixA11, S1);
            P2 = strassenMethodForMatrixMultiply(S2, matrixB22);
            P3 = strassenMethodForMatrixMultiply(S3, matrixB11);
            P4 = strassenMethodForMatrixMultiply(matrixA22, S4);
            P5 = strassenMethodForMatrixMultiply(S5, S6);
            P6 = strassenMethodForMatrixMultiply(S7, S8);
            P7 = strassenMethodForMatrixMultiply(S9, S10);
            matrixC11 = SimpleUtil.SumofMatrix(P5, P4);
            matrixC11 = SimpleUtil.minusofMatrix(matrixC11, P2);
            matrixC11 = SimpleUtil.SumofMatrix(matrixC11, P6);
            matrixC12 = SimpleUtil.SumofMatrix(P1, P2);
            matrixC21 = SimpleUtil.SumofMatrix(P3, P4);
            matrixC22 = SimpleUtil.SumofMatrix(P5, P1);
            matrixC22 = SimpleUtil.minusofMatrix(matrixC22, P3);
            matrixC22 = SimpleUtil.minusofMatrix(matrixC22, P7);
            matrixC = SimpleUtil.SubMatrix2MasterMatirx(matrixC11, matrixC, 0, 0);
            matrixC = SimpleUtil.SubMatrix2MasterMatirx(matrixC12, matrixC, 0, matrixC.length / 2);
            matrixC = SimpleUtil.SubMatrix2MasterMatirx(matrixC21, matrixC, matrixC.length / 2, 0);
            matrixC = SimpleUtil.SubMatrix2MasterMatirx(matrixC22, matrixC, matrixC.length / 2, matrixC.length / 2);
            return matrixC;
        } else {
            throw new IllegalArgumentException("矩阵大小不合法,无法相乘");
        }
    }


    public static void testForAdvancedSquareMatrixMultiply(int testTimes) {
        for (int i = 0; i < testTimes; i++) {
            int[][] matrixA = SimpleUtil.generateRandomMatrix(4);
            int[][] matrixB = SimpleUtil.generateRandomMatrix(4);
            int[][] matrixC = squareMatrixMultiply(matrixA, matrixB);
            int[][] matrixC2 = strassenMethodForMatrixMultiply(matrixA, matrixB);
            if (!SimpleUtil.isEqualMatrix(matrixC, matrixC2)) {
                System.out.println("Sorry GenerateLowestString failed");
                return;
            }
        }
        System.out.println("Nice test passed");
    }


    public static void main(String[] args) {
        testForAdvancedSquareMatrixMultiply(5000);
    }

}
