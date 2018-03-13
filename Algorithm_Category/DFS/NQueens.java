package DFS;

import java.util.List;
import java.util.ArrayList;

/**
 * Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.
 * Assumptions: N > 0
 * Return
 * A list of ways of putting the N Queens
 * Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
 */

//Time: O(n!), Space: O(n)
public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] array = new int[n]; // each index represents position of queen
        nqueens(0, array, result);
        return result;
    }

    private void nqueens(int curRow, int[] array, List<List<Integer>> result) {
        if (curRow == array.length) { // base case, all queens have been put on the borad
            result.add(toList(array));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            array[curRow] = i; // put a queen on ith column at curRow
            if (!hasConflict(curRow, array)) {
                nqueens(curRow + 1, array, result);
            }
        }
    }

    private boolean hasConflict(int curRow, int[] array) {
        for (int i = 0; i < curRow; i++) {
            if (array[i] == array[curRow]) {
                return true;
            }
            if (curRow - i == Math.abs(array[curRow] - array[i])) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }
}
