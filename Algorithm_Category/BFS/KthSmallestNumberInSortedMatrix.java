package BFS;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。

 示例：
     matrix = [
       [ 1,  5,  9],
       [10, 11, 13],
       [12, 13, 15]
     ],
     k = 8,

 返回 13。

 提示：
 你可以假设 n > 0, k 的值永远是有效的，1 ≤ k ≤ n^2
 */

//Time: O(klogn), Space: O(n^2), k's max value can be n^2
public class KthSmallestNumberInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((c1, c2) -> {
            if (c1.val == c2.val) {
                return 0;
            }
            return c1.val < c2.val ? -1 : 1;
        });
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        int[][] visited = new int[row][col];
        for (int i = 0; i < k - 1; i ++) {
            Cell cell = minHeap.poll();
            int x = cell.row;
            int y = cell.col;
            if (x + 1 < row && visited[x + 1][y] == 0) {
                minHeap.offer(new Cell(x + 1, y, matrix[x + 1][y]));
                visited[x + 1][y] = 1;
            }
            if (y + 1 < row && visited[x][y + 1] == 0) {
                minHeap.offer(new Cell(x, y + 1, matrix[x][y + 1]));
                visited[x][y + 1] = 1;
            }
        }
        return minHeap.peek().val;
    }

    static class Cell {
        private int row;
        private int col;
        private int val;
        public Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
