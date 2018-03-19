package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string with no duplicate characters, return a list with all permutations of the characters.

 Examples:
    Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
    Set = "", all permutations are [""]
    Set = null, all permutations are []
 */

//Time: O(n!), Space: O(n)
public class AllPermutationsI {
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
        for (int j = index; j < array.length; j++) {
            swap(index, j, array);
            permutations(array, index + 1, result);
            swap(index, j, array);
        }
    }

    private void swap(int first, int second, char[] array) {
        char temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
