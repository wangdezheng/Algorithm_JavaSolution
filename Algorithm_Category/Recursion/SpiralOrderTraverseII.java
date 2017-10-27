package Recursion;
import java.util.List;
import java.util.ArrayList;

/**
 * Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
 * <p>
 * Assumptions
 * <p>
 * The 2D array is not null and has size of M * N where M, N >= 0
 **/

public class SpiralOrderTraverseII {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        spiral(matrix, 0, matrix.length, matrix[0].length, result);
        return result;
    }

    private void spiral(int[][] matrix, int offset, int length, int width, List<Integer> result) {
        if (length == 0 || width == 0) {  // base case
            return;
        }
        if (length == 1) { // base case
            for (int i = 0; i < width; i++) {
                result.add(matrix[offset][offset + i]);
            }
            return;
        }
        if (width == 1) { // base case
            for (int i = 0; i < length; i++) {
                result.add(matrix[i + offset][offset]);
            }
            return;
        }

        for (int i = 0; i < width - 1; i++) { //top
            result.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < length - 1; i++) { //right
            result.add(matrix[offset + i][offset + width - 1]);
        }
        for (int i = width - 1; i >= 1; i--) { //bottom
            result.add(matrix[offset + length - 1][offset + i]);
        }
        for (int i = length - 1; i >= 1; i--) { //left
            result.add(matrix[offset + i][offset]);
        }
        spiral(matrix, offset + 1, length - 2, width - 2, result);
    }
}
