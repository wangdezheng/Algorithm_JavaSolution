package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if there exist two elements in a given array, the sum of which is the given target number.

 Assumptions:
    The given array is not null and has length of at least 2

 ​Examples:
    A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)

    A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)

    A = {2, 4, 1}, target = 4, return false
 */

//Take care of this problem, make sure what is the requirement. (Time or Space first)
//Consider whether the input array is sorted or not
//If not sorted, time first, use HashSet to solve this problem
//If sorted, use two pointers to solve this problem
//What if the memory is not enough ?
//Step1: external sort. Step2: two pointers to go through the array.

//Time: O(n), Space: O(n)
public class TwoSum {
    public boolean existSum(int[] array, int target) {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (visited.contains(array[i])) {
                return true;
            } else {
                visited.add(target - array[i]);
            }
        }
        return false;
    }
}
