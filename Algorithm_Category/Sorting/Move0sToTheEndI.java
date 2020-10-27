package Sorting;

/**
 Given an array of integers, move all the 0s to the right end of the array.
 The relative order of the elements in the original array does not need to be maintained.

 Assumptions:
   The given array is not null.

 Examples:
   {1} --> {1}
   {1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}
 */

//Time: O(n), Space: O(1)
public class Move0sToTheEndI {
  public int[] moveZero(int[] array) {
    if (array.length <= 1) {
      return array;
    }
    int i = 0;
    int j = array.length - 1;
    while(i <= j) {
      if (array[i] != 0) {
        i++;
      } else {
        swap(i, j, array);
        j--;
      }
    }
    return array;
  }
}
