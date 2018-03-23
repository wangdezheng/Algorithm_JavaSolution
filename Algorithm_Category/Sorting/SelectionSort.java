package Sorting;

/**
 * Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.

 Examples:
    {1} is sorted to {1}
    {1, 2, 3} is sorted to {1, 2, 3}
    {3, 2, 1} is sorted to {1, 2, 3}
    {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

 Corner Cases:
    What if the given array is null? In this case, we do not need to do anything.
    What if the given array is of length zero? In this case, we do not need to do anything.
 */

//Time: O(n ^ 2), Space: O(1)
public class SelectionSort {
    public int[] selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
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
