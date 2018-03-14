package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 *Given a set of characters represented by a String, return a list containing all subsets of the characters.

 Assumptions:
    There are no duplicate characters in the original set.

 ​Examples:
    Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
    Set = "", all the subsets are [""]
    Set = null, all the subsets are []
 */

//Time: O(2 ^ n), Space: O(n)
public class AllSubsetsI {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        findSubSets(array, 0, sb, result);
        return result;
    }

    private void findSubSets(char[] array, int index, StringBuilder sb, List<String> result) {
        if (index == array.length) {
            result.add(sb.toString());
            return;
        }
        findSubSets(array, index + 1, sb.append(array[index]), result);
        sb.deleteCharAt(sb.length() - 1);
        findSubSets(array, index + 1, sb, result);
    }
}
