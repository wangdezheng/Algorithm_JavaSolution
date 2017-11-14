package DynamicProgramming;

/**
 * Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.
 * <p>
 * Assumptions
 * <p>
 * The given array is not null and has length of at least 1.
 */
//Time: O(n), Space: O(1)
public class LargestSumOfSubarray {
    public int largestSum(int[] array) {
        // sum[i] represents the greatest sum of subArray from 0th position to ith position (include i)
        int[] sum = new int[array.length];
        sum[0] = array[0];
        int lastMax = sum[0];
        for (int i = 1; i < array.length; i++) {
            sum[i] = Math.max(array[i], sum[i - 1] + array[i]);
            lastMax = Math.max(lastMax, sum[i]);
        }
        return lastMax;
    }
}
