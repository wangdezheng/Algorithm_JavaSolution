package QueueAndStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.
    push(int element) - push the element to top
    pop() - return the top element and remove it, if the stack is empty, return -1
    top() - return the top element without remove it, if the stack is empty, return -1
    min() - return the current min value in the stack.

 Requirement:
    Time Complexity: O(1)
    Space Complexity: O(n)
 */

public class StackWithMin {
  private Deque<Integer> stack;
  private Deque<Integer> stackMin;

  public StackWithMin() {
    stack = new LinkedList<> ();
    stackMin = new LinkedList<>();
  }

  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    if (stack.peek().equals(stackMin.peek())) {
      stackMin.pop();
    }
    return stack.pop();
  }

  public void push(int element) {
    stack.push(element);
    if (stackMin.isEmpty()) {
      stackMin.push(element);
    } else{
      if (stackMin.peek() >= element) {
        stackMin.push(element);
      }
    }
  }

  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.peek();
  }

  public int min() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stackMin.peek();
  }
}
