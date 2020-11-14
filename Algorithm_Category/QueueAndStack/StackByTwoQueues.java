package QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 使用队列实现栈的下列操作：
    push(x) -- 元素 x 入栈
    pop() -- 移除栈顶元素
    top() -- 获取栈顶元素
    empty() -- 返回栈是否为空

 注意:
    你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的
 */
public class StackByTwoQueues {
  Queue<Integer> in;
  Queue<Integer> out;

  public StackByTwoQueues() {
    in = new LinkedList<>();
    out = new LinkedList<>();
  }

  public void push(int x) {
    in.offer(x);
  }

  public Integer pop() {
    if (in.isEmpty()) {
      return null;
    }
    while (in.size() > 1) {
      out.offer(in.poll());
    }
    Integer result = in.poll();
    in = out;
    out = new LinkedList<>();
    return result;
  }

  public Integer top() {
    if (in.isEmpty()) {
      return null;
    }
    while (in.size() > 1) {
      out.offer(in.poll());
    }
    return in.peek();
  }

  public boolean isEmpty() {
    return in.isEmpty();
  }
}
