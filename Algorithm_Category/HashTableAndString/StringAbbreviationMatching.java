package HashTableAndString;

/**
 Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

 Assumptions:
     The original string only contains alphabetic characters.
     Both input and pattern are not null.
 */

public class StringAbbreviationMatching {
    public boolean match(String input, String pattern) {
        return match(input, pattern, 0, 0);
    }
    // i represents current index of input, j represents current index of pattern
    private boolean match(String input, String pattern, int i, int j) {
        if (i == input.length() && j == pattern.length()) {
            return true;
        }
        if (i >= input.length() || j >= pattern.length()) {
            return false;
        }

        if (Character.isDigit(pattern.charAt(j))) { // jth character is digit
            int num = 0;
            while (j < pattern.length() && Character.isDigit(pattern.charAt(j))) {
                num = num * 10 + pattern.charAt(j) - '0';
                j++;
            }
            return match(input, pattern, i + num, j);
        } else { // jth character is character
            if (input.charAt(i) == pattern.charAt(j)) {
                return match(input, pattern, i + 1, j + 1);
            } else {
                return false;
            }
        }
    }
}
