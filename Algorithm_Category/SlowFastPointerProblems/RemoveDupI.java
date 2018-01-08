package SlowFastPointerProblems;

/**
 * Given a sorted array, remove duplicated elements in it and keep only one of them, return the length of result
 */


//Time: O(n), Space: O(1)
//slow: all elements to the left side of slow(included) are the final results to return
//fast: current index
public class RemoveDupI {
    public int removeDup(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int slow = 0;

        for (int fast = 1; fast < input.length; fast++) {
            if (input[slow] == input[fast]) {
                continue;
            }
            input[++slow] = input[fast];
        }
        return slow + 1;
    }
}
