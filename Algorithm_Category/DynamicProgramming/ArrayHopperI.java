package DynamicProgramming;

/**
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). Determine if you are able to reach the last index.
 * <p>
 * Assumptions
 * <p>
 * The given array is not null and has length of at least 1.
 * Examples
 * <p>
 * {1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)
 * <p>
 * {2, 1, 1, 0, 2}, we are not able to reach the end of array
 */
//Time: O(n ^ 2), Space: O(n)
public class ArrayHopperI {
    public boolean canJump(int[] array) {
        int len = array.length;
        //carReach[i] represents whether the ith element can reach the end of array
        boolean[] canReach = new boolean[len];
        // the last element is at the end of array, set it true
        canReach[len - 1] = true;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = array[i]; j >= 1; j--) {
                if (i + j < len && canReach[i + j] == true) {
                    canReach[i] = true;
                    break;
                }
            }
        }
        return canReach[0];
    }
}
