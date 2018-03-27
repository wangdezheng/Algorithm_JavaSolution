package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given a string with possible duplicate characters, return a list with all permutations of the characters.

 Examples:
    Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
    Set = "aba", all permutations are ["aab", "aba", "baa"]
    Set = "", all permutations are [""]
    Set = null, all permutations are []
 */

//Time: O(n!), Space: O(n)
public class AllPermtationsII {
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        permutations(array, 0, result);
        return result;
    }

    private void permutations(char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        HashSet<Character> visited = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (visited.add(array[i])) {
                swap(array, i, index);
                permutations(array, index + 1, result);
                swap(array, i, index);
            }
        }
    }

    private void swap(char[] array, int first, int second) {
        char temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
