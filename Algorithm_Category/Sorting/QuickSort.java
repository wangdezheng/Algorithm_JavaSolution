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

//Time: O(nlogn), Space: O(logn)
public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int i = left;
        int pivot = array[right];
        int j = right - 1;
        while (i <= j) {
            if (array[i] < pivot) {
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
