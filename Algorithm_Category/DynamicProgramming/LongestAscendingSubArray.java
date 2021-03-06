package DynamicProgramming;

/**
 * Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.
 */

//Time: O(n), Space: O(1)
public class LongestAscendingSubArray {
    public int longest(int[] array) {
        if (array.length <= 1) {
            return array.length;
        }
        // only need to record latest longest ascending subArray length from 0th to ith(include ith element)
        int cur = 1;
        int result = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                cur = cur + 1;
                result = Math.max(result, cur);
            } else {
                cur = 1;
            }
        }
        return result;
    }
}
