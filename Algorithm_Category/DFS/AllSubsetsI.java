package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing all subsets of the
 * characters.
 *
 * Assumptions: There are no duplicate characters in the original set.
 *
 * Examples:
 * Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
 * Set ="", all the subsets are [""]
 * Set = null, all the subsets are []
 */

// Time: O(2 ^ n), Space: O(n)
public class AllSubsetsI {
  public List<String> subSets(String set) {
    List<String> result = new ArrayList<>();
    if (set == null) {
      return result;
    }
    StringBuilder sb = new StringBuilder();
    backTrace(set, 0, sb, result);
    return result;
  }

  private void backTrace(String set, int start, StringBuilder sb, List<String> result) {
    result.add(new String(sb));
    for (int i = start; i < set.length(); i++) {
      sb.append(set.charAt(i));
      backTrace(set, i + 1, sb, result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
