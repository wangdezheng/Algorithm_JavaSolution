package DynamicProgramming;

/**
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.
 * <p>
 * Assumptions
 * <p>
 * The given array is not null and has length of at least 1.
 * Examples
 * <p>
 * {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
 * <p>
 * {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
 */
//Time: O(n ^ 2), Space: O(n)
public class ArrayHopperII {
    public int minJump(int[] array) {
        int len = array.length;
        //minJump[i] represents the min jump from ith position to target position
        int[] minJump = new int[len];
        minJump[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            int minJumpToTarget = Integer.MAX_VALUE;
            for (int j = 1; j <= array[i]; j++) {
                if (i + j <= len - 1 && minJump[i + j] >= 0) {
                    minJumpToTarget = Math.min(minJumpToTarget, minJump[i + j]);
                }
            }
            // Judge whether can reach target or not
            if (minJumpToTarget != Integer.MAX_VALUE) {
                minJump[i] = 1 + minJumpToTarget;
            } else {
                minJump[i] = -1;
            }
        }
        return minJump[0];
    }
}
