package Sorting;

/**
 * Given an array of balls, where the color of the balls can only be Red, Green or Blue,
 * sort the balls such that all the Red balls are grouped on the left side,
 * all the Green balls are grouped in the middle and all the Blue balls are grouped on the right side.
 * (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).

 Examples:
    {0} is sorted to {0}
    {1, 0} is sorted to {0, 1}
    {1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}

 Assumptions:
    The input array is not null.

 Corner Cases:
    What if the input array is of length zero? In this case, we should not do anything as well
 */

// i: All letters to the left hand side of i(included) are red(-1) balls.
// j: Current index to go through the array
// k: All letters to the right hand side of k(not included) are blue balls(1).
// [i, j] (Both not included)letters in this section are green balls(0).
// [j, k]:(Both included) letters in this section are unknown area to explore.

//Time: O(n), Space: O(1)
public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int pivot = 0;
        int i = -1;
        int j = 0;
        int k = array.length - 1;
        while (j <= k) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
                j++;
            } else if (array[j] == pivot) {
                j++;
            } else {
                swap(array, j, k);
                k--;
            }
        }
        return array;
    }

    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
