package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).

 Assumptions:
        In each of the two sorted arrays, there could be duplicate numbers.
        Both two arrays are not null.

 Examples:
        A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 */
//Take care of this problem, make sure two arrays are sorted or not, size of array1 vs array2, optimize time or space
//Solution1: Two pointers, Time: O(m + n), Space: O(1)
//Solution2: size m << size n, for each element m, do binary search in array n. Time: O(mlogn), Space: O(1)
//Solution3: What if unsorted, sorted first and do previous algorithm.
//           Time: O(m + n + mlogm + nlogn), Space: O(logm + logn) on average if quick sort, O(m + n) worst case
//Solution4: Unsorted, use HashSet, hash the smaller array, go through larger array. Time: O(m + n), Space: O(min(m,n))

//Time: O(m + n), Space: O(1)
public class CommonNumbersOfTwoSortedArrays {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while(i < A.size() && j < B.size()) {
            if (A.get(i) == B.get(j)) {
                result.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
