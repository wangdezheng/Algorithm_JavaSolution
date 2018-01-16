package SlowFastPointerProblems;

/**
 * Given an array of random numbers, push all the zero's of a given array to the end of the array.
 * For example, the given array is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to
 * {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements can be changed.
 * Expected time complexity is O(n) and extra space is O(1)
 */

//left index: All elements to the left hand side of left(not including left) are non-zeros.
// right index: All elements to the right hand side of right(not including right) are zeros.
public class PushZerosI {
    public int pushZerosI(int[] input) {
        if (input == null || input.length <= 1) {
            return -1;
        }
        int left = 0;
        int right = input.length - 1;
        while(left <= right) {
            if (input[left] != 0) {
                left++;
            } else if (input[right] == 0) {
                right--;
            } else {
                swap(left, right, input);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int left, int right, int[] input) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
