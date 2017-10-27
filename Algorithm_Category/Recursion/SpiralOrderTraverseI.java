package Recursion;
import java.util.List;
import java.util.ArrayList;

/**
 * Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
 * <p>
 * Assumptions:
 * <p>
 * The 2D array is not null and has size of N * N where N >= 0
 **/

public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            for (int i = start; i <= end - 1; i++) {
                result.add(matrix[start][i]);
            }
            for (int i = start; i <= end - 1; i++) {
                result.add(matrix[i][end]);
            }
            for (int i = end; i >= start + 1; i--) {
                result.add(matrix[end][i]);
            }
            for (int i = end; i >= start + 1; i--) {
                result.add(matrix[i][start]);
            }
            start++;
            end--;
        }
        if (start == end) {
            result.add(matrix[start][end]);
        }
        // spiral(matrix, 0, matrix.length, result); // recursion way
        return result;
    }

    // private void spiral(int[][] matrix, int offset, int size, List<Integer> result) {
    //   if (size == 0) { //base case
    //     return;
    //   }
    //   if (size == 1) { //base case
    //     result.add(matrix[offset][offset]);
    //     return;
    //   }

    //   for (int i = 0; i < size - 1; i++) {
    //     result.add(matrix[offset][i + offset]); // top
    //   }
    //   for (int i = 0; i < size - 1; i++) {
    //     result.add(matrix[offset + i][offset + size - 1]); // right
    //   }
    //   for (int i = size - 1; i >= 1; i--) {
    //     result.add(matrix[offset + size - 1][offset + i]); // bottom
    //   }
    //   for (int i = size - 1; i >= 1; i--) {
    //     result.add(matrix[offset + i][offset]); // left
    //   }
    //   spiral(matrix, offset + 1, size - 2, result);
    // }

}
