package problems.matrixrotation;

import org.junit.Assert;

import java.util.Arrays;

/**
 * Created by jfreire on 22.07.17.
 */
public class RotateMatrix {

    /**
     * Given an N x N matrix, rotate 90 degrees right
     * <p>
     * i.e.
     * [ 1 2 3 ]    [ 2 1 1 ]   [ 2 2 2 ]   [ 3 1 2 ]   [ 1 2 3 ]
     * [ 1 1 1 ]  = [ 2 1 2 ] = [ 1 1 1 ] = [ 2 1 1 ] = [ 1 1 1 ]
     * [ 2 2 2 ]    [ 2 1 3 ]   [ 3 2 1 ]   [ 1 1 2 ]   [ 2 1 2 ]
     * <p>
     */
    static int[][] rotate(int[][] matrix) {
        int[][] R = new int[matrix.length][matrix.length];

        //Basically transform rows to columns; 1st row is last column, last row is first column, middle row middle col.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                R[matrix.length - j][i] = matrix[i][j];
            }
        }
        return R;
    }


    static int[][] swap(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return null;

        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            //Organize different layers from top to bottom; it goes from 0 to half - 1.

            //These two control the layers in play for each iteration
            //i.e. In the first it. The first and last layers play
            //In the second it. The second and one before last play.
            // usw.
            //
            int first = layer; //Increment
            int last = n - 1 - layer; //Decrement
            //
            //Iterate first to last elements
            //
            //
            for (int i = first; i < last; ++i) {
              //Same operation for each iteration.
                //Identify which operation to perform and then manage nitty-gritty indexes.
                //Determine where we are in the it.
                int offset = i - first;
                //save top
                int top = matrix[first][i];
                //left -> top
                matrix[first][i] = matrix[last - offset][first];
                //bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                //right-> bottom
                matrix[last][last - offset] = matrix[i][last];
                //top -> right
                matrix[i][last] = top;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {

        // 3 x 3 //
        int[][] M = new int[][]{{1, 2, 3}, {1, 1, 1}, {2, 2, 2}};
        int[][] N = new int[][]{{2, 1, 1}, {2, 1, 2}, {2, 1, 3}};

        // 4 x 4 //
        int[][] U = new int[][]{{1, 2, 3, 4}, {1, 1, 1, 1}, {2, 2, 2, 2}, {1,5,8,4}};
        int[][] V = new int[][]{{1, 2, 1, 1}, {5, 2, 1, 2}, {8, 2, 1, 3}, {4, 2, 1, 4}};

        Assert.assertTrue(Arrays.deepEquals(swap(M), N));
        //Back to origin
        Assert.assertTrue(Arrays.deepEquals(swap(swap(swap(swap(M)))), M));

        //
        Assert.assertTrue(Arrays.deepEquals(swap(U), V));
        //Back to origin
        Assert.assertTrue(Arrays.deepEquals(swap(swap(swap(swap(U)))), U));


    }
}
