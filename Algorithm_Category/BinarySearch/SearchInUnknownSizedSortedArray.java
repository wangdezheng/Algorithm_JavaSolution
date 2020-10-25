package BinarySearch;

/**
 Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order, determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.

 Assumptions:
    dictionary A is not null
    dictionary.get(i) will return null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds

 Examples:
    A = {1, 2, 5, 9, ......}, T = 5, return 2
    A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
 */
public class SearchInUnknownSizedSortedArray {
  public int search(Dictionary dict, int target) {
    int i = 1;
    while (dict.get(i) != null && dict.get(i) < target) {
      i = i * 2;
    }
    return binarySearch(i / 2, i, dict, target);
  }

  private int binarySearch(int left, int right, Dictionary dict, int target) {
    while (left <= right) {
      int mid = (left + right) / 2;
      if (dict.get(mid) == null) {
        right = mid - 1;
      } else if (dict.get(mid) == target) {
        return mid;
      } else if (dict.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
