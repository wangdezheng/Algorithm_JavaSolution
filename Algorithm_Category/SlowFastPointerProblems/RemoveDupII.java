package SlowFastPointerProblems;

/**
 * Given a sorted array, remove duplicated elements in it and keep at most two of them, return the length of result
 */

//Time: O(n), Space: O(1)
//slow: all elements to the left side of slow(included) are the final results to return
//fast: current index
public class RemoveDupII {
    public int removeDup(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int slow = 0;
        int counter = 1;

        for (int fast = 1; fast < input.length; fast++) {
            if (input[slow] == input[fast]) {
                if (counter < 2) {
                    input[++slow] = input[fast];
                    counter++;
                }
            } else {
                input[++slow] = input[fast];
                counter = 1;
            }

        }
        return slow + 1;
    }
}