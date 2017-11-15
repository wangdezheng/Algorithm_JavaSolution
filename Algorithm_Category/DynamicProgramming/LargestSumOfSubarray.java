package DynamicProgramming;

/**
 * Given an unsorted integer array, find the subArray that has the greatest sum. Return the sum.
 * <p>
 * Assumptions
 * <p>
 * The given array is not null and has length of at least 1.
 */
//Time: O(n), Space: O(1)
public class LargestSumOfSubarray {
    public int largestSum(int[] array) {
        // lastMax represents the max sum from 0th to ith position
        int max = Integer.MAX_VALUE;
        int lastMax = array[0];
        for (int i = 1; i < array.length; i++) {
            lastMax = Math.max(array[i], lastMax + array[i]);
            max = Math.max(max, lastMax);
        }
        return max;
    }
}
