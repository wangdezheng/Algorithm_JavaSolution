package BinarySearch;

/**
 * Given a 2D matrix that contains integers only, which each row is sorted in an ascending order.
 * The first element of next row is larger than (or equal to) the last element of previous row.
 *
 * Given a target number, returning the position that the target locates within the matrix. If the
 * target number does not exist in the matrix, return {-1, -1}.
 *
 * Assumptions:
 *      The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
 * Examples:
 *      matrix = { {1, 2, 3}, {4, 5, 7},{8, 9, 10} }
 *      target = 7, return {1, 2}
 *      target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
 */
public class SearchInSortedMatrix {
  public int[] search(int[][] matrix, int target) {
    if (matrix == null) {
      return new int[] {-1, -1};
    }
    int left = 0;
    int right = matrix.length * matrix[0].length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      int x = mid / matrix[0].length;
      int y = mid % matrix[0].length;
      if (matrix[x][y] == target) {
        return new int[] {x, y};
      } else if (matrix[x][y] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return new int[] {-1, -1};
  }
}
