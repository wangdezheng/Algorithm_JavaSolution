package LinkedList;

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

  public Solution() {
    stackIn = new ArrayDeque<> ();
    stackOut = new ArrayDeque<> ();
  }

  public Integer poll() {
    if (stackOut.isEmpty()) {
      while (!stackIn.isEmpty()) {
        stackOut.offerLast(stackIn.pollLast());
      }
    }
    return stackOut.pollLast();
  }

  public void offer(int element) {
    stackIn.offerLast(element);
  }

  public Integer peek() {
    if (stackOut.isEmpty()) {
      while (!stackIn.isEmpty()) {
        stackOut.offerLast(stackIn.pollLast());
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
