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
  public int[] solve(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    int min = 0;
    for (int i = 0; i < array.length; i++) {
      min = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[min] > array[j]) {
          min = j;
        }
      }
      swap(array, i, min);
    }
    return array;
  }

  private void swap(int[] array, int first, int second) {
    int temp = array[first];
    array[first] = array[second];
    array[second] = temp;
  }
}
