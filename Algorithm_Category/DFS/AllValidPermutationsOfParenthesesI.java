package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given N pairs of parentheses “()”, return a list with all the valid permutations.
 * <p>
 * Assumptions
 * <p>
 * N >= 0
 * Examples
 * <p>
 * N = 1, all valid permutations are ["()"]
 * N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 * N = 0, all valid permutations are [""]
 */

//Time: O(2 ^ n), Space: O(n)
public class AllValidPermutationsOfParenthesesI {
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        char[] array = new char[n * 2];
        validParentheses(array, 0, 0, 0, result);
        return result;
    }

    public void validParentheses(char[] array, int left, int right, int pos, List<String> result) {
        if (left + right == array.length) { //base case, return
            result.add(new String(array));
            return;
        }

        if (left < array.length / 2) {
            array[pos] = '(';
            validParentheses(array, left + 1, right, pos + 1, result);
        }

        if (right < left) {
            array[pos] = ')';
            validParentheses(array, left, right + 1, pos + 1, result);
        }
    }


}
