package Recursion;

/**
 * Generate an M * N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, …, M * N in increasing order.
 * <p>
 * Assumptions
 * <p>
 * M >= 0, N >= 0
 **/
public class SpiralOrderGenerate {
    public int[][] spiralGenerate(int m, int n) {
        if (m == 0 || n == 0) {
            return new int[m][n];
        }
        int[][] result = new int[m][n];
        spiralGenerate(m, n, 1, 0, result);
        return result;
    }

    private void spiralGenerate(int length, int width, int count, int offset, int[][] result) {
        if (length == 0 || width == 0) { //base case
            return;
        }
        if (length == 1) {  //base case
            for (int i = 0; i < width; i++) {
                result[offset][offset + i] = count++;
            }
            return;
        }
        if (width == 1) {   //base case
            for (int i = 0; i < length; i++) {
                result[offset + i][offset] = count++;
            }
            return;
        }

        for (int i = 0; i < width - 1; i++) { // top, row doesn't change, col++
            result[offset][offset + i] = count++;
        }

        for (int i = 0; i < length - 1; i++) { // right, col doesn't change, row++
            result[offset + i][offset + width - 1] = count++;
        }

        for (int i = width - 1; i >= 1; i--) { // bottom, row doesn't change, col--
            result[offset + length - 1][offset + i] = count++;
        }

        for (int i = length - 1; i >= 1; i--) { // left, col doesn't change, row--
            result[offset + i][offset] = count++;
        }

        spiralGenerate(length - 2, width - 2, count, offset + 1, result);
    }
}
