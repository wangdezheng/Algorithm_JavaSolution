package Array;

import java.util.HashMap;

/**
 * Find longest sub-array whose sum is equal to 0. Return the length of the sub-array.
 *
 * Examples:
 *
 *      A = {-1, 2, -1, 0, 0, -1, 0, 3}, return 6
 */

//Time: O(n), Space: O(n)
public class FindLongestSubArraySumToTarget {
    public int findLongestSubArraySumToTarget(int[] array){
        if (array == null || array.length <= 0) {
            return 0;
        }
        int max = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < array.length; i++) {
            sum += array[i];
            if (sum == 0) {
                max = Math.max(max, i + 1);
            } else {
                if (map.containsKey(sum)) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return max;
    }
}
