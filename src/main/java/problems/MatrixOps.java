package problems;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

/**
 * Created by jfreire on 19.07.17.
 */
public class MatrixOps {

    public static void main(String[] args) {

        int[][] A = new int[][]{{1, 2, 3}, {3, 2, 1}, {1, 0, 1}};
        //
        int[][] A_Transposed = new int[][]{{1, 3, 1}, {2, 2, 0}, {3, 1, 1}};
        int[][] A_Zeroed = new int[][]{{1, 0, 3}, {3, 0, 1}, {0, 0, 0}};
        //
        int[][] B = new int[][]{{1, 2, 3}, {1, 4, 5}, {2, 4, 6}};

        int[][] MULT = new int[][]{{14, 14, 14}, {10, 10, 10}, {4, 4, 4}};

        //Bidimensional arrrays need deepEquals
        Assert.check(Arrays.deepEquals(transpose(A), A_Transposed), "Test 1 failed");

        Assert.check(Arrays.deepEquals(zeroRowCols(A), A_Zeroed), "Test 2 failed");

        Assert.check(Arrays.deepEquals(mult(A, B), MULT), "Test 3 failed");

    }


    /**
     * Transposing.
     *
     * @param A
     * @return
     */
    static int[][] transpose(int[][] A) {

        int[][] R = new int[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                R[j][i] = A[i][j];
            }
        }
        return R;
    }

    static int[][] zeroRowCols(int[][] A) {

        int[][] R = new int[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {

                if (A[i][j] == 0) {
                    //Zero all rows
                    for (int k = 0; k < A.length; k++) {
                        R[i][k] = 0;
                    }
                    //Zero all cols
                    for (int l = 0; l < A.length; l++) {
                        R[l][j] = 0;
                    }
                    break;
                } else {
                    R[i][j] = A[i][j];
                }
            }
        }
        return R;
    }

    /**
     * @param A
     * @param B
     * @return
     */
    static int[][] mult(int[][] A, int[][] B) {

        int[][] R = new int[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {

                R[i][j] += mmult(A, B, i, j);
            }
        }
        return R;
    }

    static int mmult(int[][] A, int[][] B, int i, int j) {
        int res = 0;
        for (int l = 0; l < A.length; l++)
            res += (A[i][l] * B[l][j]);
        return res;
    }
}
