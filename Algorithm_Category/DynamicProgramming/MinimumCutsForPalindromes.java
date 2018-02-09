package DynamicProgramming;

/**
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. Determine the fewest cuts needed for a palindrome partitioning of a given string.

 Assumptions:
    The given string is not null

 Examples:
    “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.

    The minimum number of cuts needed is 3.
 */
//Time: O(n ^ 3), Space: O(n)
public class MinimumCutsForPalindromes {
    public int minCuts(String input) {
        if (input.length() <= 1) {
            return 0;
        }
        char[] array = input.toCharArray();
        // cut[i] represents the minimum cut at length i + 1
        int[] cut = new int[array.length];
        for (int i = 1; i < cut.length; i++) {
            // if the string is already palindrome, then we don't need to cut it
            if (isPalindrome(array, 0, i)) {
                cut[i] = 0;
                continue;
            }
            //max cut is to divided it into single character
            cut[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPalindrome(array, j + 1, i)) {
                    cut[i] = Math.min(cut[i], cut[j] + 1);
                }
            }
        }
        return cut[cut.length - 1];
    }

    private boolean isPalindrome(char[] array, int left, int right) {
        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
