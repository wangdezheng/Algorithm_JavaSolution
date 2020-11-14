package QueueAndStack;

import java.util.LinkedList;

/**
 Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).
 After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.

 Assumptions:
    The given stack is not null.
    There can be duplicated numbers in the give stack.

 Requirements:
    No additional memory, time complexity = O(n ^ 2).
 */

public class SortWith2Stacks {
  public void sort(LinkedList<Integer> s1) {
    if (s1.size() <= 1) {
      return;
    }
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    int count = 0;
    while (!s1.isEmpty()) {
      int smallest = Integer.MAX_VALUE;
      while (!s1.isEmpty()) {
        int temp = s1.pop();
        if (temp < smallest) {
          smallest = temp;
        }
        s2.push(temp);
      }
      while (!s2.isEmpty() && s2.peek() >= smallest) {
        int value = s2.pop();
        if (value == smallest) {
          count++;
        } else {
          s1.push(value);
        }
      }
      while (count != 0) {
        s2.push(smallest);
        count--;
      }
    }
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
  }
}
