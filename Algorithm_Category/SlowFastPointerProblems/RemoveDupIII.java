package SlowFastPointerProblems;
/**
 * Given a sorted array, remove duplicated elements in it and don't keep them, return the length of result
 */

//Time: O(n), Space: O(1)
//slow: all elements to the left side of slow(not included) are the final results to return
//fast: current index
public class RemoveDupIII {
    public int removeDup(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            int begin = fast;
            while (fast < input.length && input[begin] == input[fast]) {
                fast++;
            }
            if (fast - begin == 1) {
                input[slow++] = input[begin];
            }
        }
        return slow;
    }
}