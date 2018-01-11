package SlowFastPointerProblems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an unsorted array, deduplicate adjacent letters repeatedly.
 * Example: a b b b b a z w  -->  z w
 */

//Time: O(n), Space: O(n)
public class RemoveAdjacentRepeatedly {
    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while(i < array.length) {
            char cur = array[i];
            if (!stack.isEmpty() && cur == stack.peekLast()) {
                while(i < array.length && cur == array[i]) {
                    i++;
                }
                stack.pollLast();
            } else {
                stack.offerLast(cur);
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stack.peekFirst() != null) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
