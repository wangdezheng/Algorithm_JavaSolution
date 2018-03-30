package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.

 Assumptions:
        The given array is not null and has length of at least 2
        The order of the values in the pair does not matter

 Examples:
        A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
 */

//Method1: Sort the array, and using two pointers to go through the array to find all valid pairs.
//Method2: Record the number of existence of each element
//         Two cases when need to make the pair a solution:
//               1. if 2 * x == target, make sure there is no duplicates
//               2. if x + y == target, make sure this is the first time of x is present

//Time: O(n), Space: O(n)
public class TwoSumPairII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            Integer count = map.get(num);
            if (num * 2 == target && count != null && count == 1) {
                result.add(Arrays.asList(num, num));
            }
            if (map.containsKey(target - num) && count == null) {
                result.add(Arrays.asList(target - num, num));
            }
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        return result;
    }
}
