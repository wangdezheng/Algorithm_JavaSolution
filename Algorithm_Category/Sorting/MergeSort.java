package Sorting;

/**
 * Given an array of integers, sort the elements in the array in ascending order. The merge sort algorithm should be used to solve this problem.

 Examples:
    {1} is sorted to {1}
    {1, 2, 3} is sorted to {1, 2, 3}
    {3, 2, 1} is sorted to {1, 2, 3}
    {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
    Corner Cases

 What if the given array is null? In this case, we do not need to do anything.
 What if the given array is of length zero? In this case, we do not need to do anything.
 */

//Time: O(nlogn), Space: O(n)
public class MergeSort {
    public int[] mergeSort(int[] array) {
        int[] helper = new int[array.length];
        if (array == null || array.length == 0){
            return array;
        }
        split(array, helper, 0, array.length - 1);
        return array;
    }

    private void split(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        split(array, helper, left, mid);
        split(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int index = left;
        int i = left;
        int j = mid + 1;
        while(i <= mid && j <= right) {
            if (helper[i] < helper[j]) {
                array[index++] = helper[i++];
            } else {
                array[index++] = helper[j++];
            }
        }
        while (i <= mid) {
            array[index++] = helper[i++];
        }
        while (j <= mid) {
            array[index++] = helper[j++];
        }
    }
}
