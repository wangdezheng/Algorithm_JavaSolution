package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of size n（with duplicate）, return all possible combinations of k elements in array. For example,
 * if input array is {1 2 2 3} and k == 3, then output should be {122}, {123}, {222}. {223}.
 */

//Time: O(2 ^ n), Space: O(n)
public class CombinationsOfKElementsInArray {
    public List<List<Integer>> permuteUnique(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        permuteUnique(nums, k, 0, cur, result);
        return result;
    }

    private void permuteUnique(int[] nums, int k, int index, List<Integer> cur, List<List<Integer>> result) {
        if (index == nums.length) {
            if (cur.size() == k) {
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        cur.add(nums[index]);
        permuteUnique(nums, k, index + 1, cur, result);
        while(index < nums.length - 1 && nums[index + 1] == nums[index]) {
            index++;
        }
        cur.remove(cur.size() - 1);
        permuteUnique(nums, k, index + 1, cur, result);
    }
}
