package LinkedList;

/**
 Implement a deque by using three stacks.
 The queue should provide size(), isEmpty(),offerFirst(), offerLast(), pollFirst(), pollLast(), peekFirst() and peekLast() operations.
 When the queue is empty, pollFirst(), pollLast(), peekFirst() and peek() should return null.
 */
public class StackByTwoQueues {
  Deque<Integer> first;
  Deque<Integer> last;
  Deque<Integer> temp;

  public Solution() {
    first = new LinkedList<>();
    last = new LinkedList<>();
    temp = new LinkedList<>();
  }

  public void offerFirst(int element) {
    first.push(element);
  }

  public void offerLast(int element) {
    last.push(element);
  }

  public Integer pollFirst() {
    if (!first.isEmpty()) {
      return first.pop();
    }
    while (!last.isEmpty()) {
      temp.push(last.pop());
    }
    if (!temp.isEmpty()) {
      first = temp;
      temp = last;
      return first.pop();
    }
    return null;
  }

  public Integer pollLast() {
    if (!last.isEmpty()) {
      return last.pop();
    }
    while (!first.isEmpty()) {
      temp.push(first.pop());
    }
    if (!temp.isEmpty()) {
      last = temp;
      temp = first;
      return last.pop();
    }
    return null;
  }

  public Integer peekFirst() {
    if (!first.isEmpty()) {
      return first.peek();
    }
    while (!last.isEmpty()) {
      temp.push(last.pop());
    }
    if (!temp.isEmpty()) {
      first = temp;
      temp = last;
      return first.peek();
    }
    return null;
  }

  public Integer peekLast() {
    if (!last.isEmpty()) {
      return last.peek();
    }
    while (!first.isEmpty()) {
      temp.push(first.pop());
    }
    if (!temp.isEmpty()) {
      last = temp;
      temp = first;
      return last.peek();
    }
    return null;
  }

  public int size() {
    return first.size() + last.size();
  }

  public boolean isEmpty() {
    return first.isEmpty() && last.isEmpty();
  }
}
