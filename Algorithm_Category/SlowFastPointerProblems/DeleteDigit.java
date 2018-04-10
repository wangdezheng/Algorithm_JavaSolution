package SlowFastPointerProblems;

/**
 * 给你一个字符串，其中包含数字也包含字母。找出其中的数字，
 并根据数字删除数字, 以及数字后面等于数字数量的字符。 数字仅限为0~9

 Examples:
        Abc1xy —— Abcy， 删除1，以及1后面1个字符x
        Abc2x2y—— Abcy, 删除2， 以及2后面2个字符 “x2”
        Abc2x2y19 —— Abcy, 删除2， 以及2后面2个字符 “x2”, 再删除1， 以及1后一个字符”9”
 */

//Time: O(n), Space: O(1)
public class DeleteDigit {
    public static String deleteDigit(String input) {
        if (input == null || input.length() <= 0) {
            return "";
        }
        char[] array = input.toCharArray();

        //删除后的字符串的最后一位的index
        int i = -1;
        //当前index, 遍历数组
        int j = 0;
        while (j < array.length) {
            //当前字符是数字0-9
            if (array[j] >= '0' && array[j] <= '9') {
                j += array[j] - '0' + 1;
            }else {
                array[++i] = array[j++];
            }
        }
        return new String(array, 0, i + 1);
    }
}
