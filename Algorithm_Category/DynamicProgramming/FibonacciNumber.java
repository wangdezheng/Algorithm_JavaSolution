package DynamicProgramming;

/**
 * Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).
 * <p>
 * Examples
 * <p>
 * 0th fibonacci number is 0
 * 1st fibonacci number is 1
 * 2nd fibonacci number is 1
 * 3rd fibonacci number is 2
 * 6th fibonacci number is 8
 */

//Time: O(n), Space: O(1)
public class FibonacciNumber {
    public long fibonacci(int K) {
        if (K <= 0) {
            return 0;
        }
        long preOfPre = 0;
        long pre = 1;
        long cur = 1;
        for (int i = 2; i <= K; i++) {
            cur = pre + preOfPre;
            preOfPre = pre;
            pre = cur;
        }
        return cur;
    }
}
