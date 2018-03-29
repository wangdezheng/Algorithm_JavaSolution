package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.

 Assumptions:
        The given array is not null and has length of at least 2.

 Examples:
        A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]
        A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
 */

//Iterate array, i is current index
//  Step 1: check the map, if contains n (n = array(i)), it means that successfully finding m(m = target - n) ,
//          get m' index list from the map,
//          for each index j in the index list, put (j, i) pair into result.
//  Step 2: check the map, if not contains m (m = target - current value), create index list for element m.
//  Step 3: get m' index list from the map, put m' index into it.

//Time: O(n), Space: O(n)
public class TwoSumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                List<Integer> list = map.get(array[i]);
                for (Integer j : list) {
                    result.add(Arrays.asList(j, i));
                }
            }

            if (!map.containsKey(target - array[i])) {
                map.put(target - array[i], new ArrayList<>());
            }
            map.get(target - array[i]).add(i);
        }
        return result;
    }
}
