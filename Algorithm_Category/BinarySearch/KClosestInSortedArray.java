package BinarySearch;

/**
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A. If there is a tie, the smaller elements are always preferred.

 Assumptions:
    A is not null
    K is guranteed to be >= 0 and K is guranteed to be <= A.length

 Return:
    A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.

 Examples:
    A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
    A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 */
public class KClosestInSortedArray {
  public int[] kClosest(int[] array, int target, int k) {
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = (left + right) / 2;
      if (array[mid] == target) {
        left = mid;
        right = mid + 1;
        break;
      } else if (array[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      if (left >= 0 && right <= array.length - 1) {
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
          result[i] = array[left--];
        } else {
          result[i] = array[right++];
        }
      } else if (left >= 0) {
        result[i] = array[left--];
      } else {
        result[i] = array[right++];
      }
    }
    return result;
  }
}
