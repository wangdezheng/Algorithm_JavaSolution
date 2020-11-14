package QueueAndStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 Implement a queue by using two stacks.
 The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. When the queue is empty, poll() and peek() should return null.

 Assumptions:
    The elements in the queue are all Integers.
    size() should return the number of elements buffered in the queue.
    isEmpty() should return true if there is no element buffered in the queue, false otherwise.
 */

public class QueueByTwoStacks {
  Deque<Integer> stackIn;
  Deque<Integer> stackOut;

  public QueueByTwoStacks() {
    stackIn = new LinkedList<>();
    stackOut = new LinkedList<> ();
  }

  public Integer poll() {
    if (stackOut.isEmpty()) {
      while (!stackIn.isEmpty()) {
        stackOut.push(stackIn.pop());
      }
    }
    return stackOut.pop();
  }

  public void offer(int element) {
    stackIn.push(element);
  }

  public Integer peek() {
    if (stackOut.isEmpty()) {
      while (!stackIn.isEmpty()) {
        stackOut.push(stackIn.pop());
      }
    }
    return stackOut.peekLast();
  }

  public int size() {
    if (!stackIn.isEmpty() && !stackOut.isEmpty()) {
      return stackIn.size() + stackOut.size();
    } else if (stackIn.isEmpty()) {
      return stackOut.size();
    } else {
      return stackIn.size();
    }
  }

  public boolean isEmpty() {
    if (!stackIn.isEmpty() || !stackOut.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }
}
