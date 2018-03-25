package Sorting;

/**
 * Given an array of integers, sort the elements in the array in ascending order. The insertion sort algorithm should be used to solve this problem.

 Examples:
 {1} is sorted to {1}
 {1, 2, 3} is sorted to {1, 2, 3}
 {3, 2, 1} is sorted to {1, 2, 3}
 {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

 Corner Cases:
 What if the given array is null? In this case, we do not need to do anything.
 What if the given array is of length zero? In this case, we do not need to do anything.
 */

//Time: O(n^2), Space: O(1)
public class InsertionSort {
    public static void insertionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int j;
        int temp;
        for (int i = 1; i < array.length; i++) {
           temp = array[i];
           j = i - 1;
           while(j >= 0 && temp < array[j]) {
               array[j + 1] = array[j];
               j--;
           }
           array[j + 1] = temp;
       }
    }
}
