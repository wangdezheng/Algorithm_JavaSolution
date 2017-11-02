package DynamicProgramming;
/**
 * Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
 * <p>
 * Assumptions
 * <p>
 * A is not null
 * Examples
 * Input: A = {5, 2, 6, 3, 4, 7, 5}
 * Output: 4
 * Because [2, 3, 4, 5] is the longest ascending subsequence.
 */
//Time: O(n^2), Space: O(n)
public class LongestAscendingSubsequence {
    public int longest(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        // longest[i] represents the longest length of ascending subsequence from 0th to ith (include i)
        int[] longest = new int[array.length];
        longest[0] = 1;
        int result = 1;
        for (int i = 1; i < array.length; i++) {
            // the shortest length of ascending subsequence is 1
            longest[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    longest[i] = Math.max(longest[j] + 1, longest[i]);
                }
            }
            result = Math.max(longest[i], result);
        }
        return result;
    }
}
