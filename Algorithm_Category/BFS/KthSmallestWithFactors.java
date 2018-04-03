package BFS;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Description:
        Find the Kth smallest number s such that s = 3 ^ x 5 ^ y 7 ^ z, x > 0 and y > 0 and z > 0, x, y, z are all integers.

 Assumptions:
        K >= 1

 Examples:
        the smallest is 3 5 7 = 105
        the 2nd smallest is 3 ^ 2 5 7 = 315
        the 3rd smallest is 3 5 ^ 2 7 = 525
        the 5th smallest is 3 ^ 3 5 7 = 945
 */

//Time: O(klogk), Space: O(k)
public class KthSmallestWithFactors {
    public long kth(int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> visited = new HashSet<>();
        pq.offer(3 * 5 * 7L);
        visited.add(3 * 5 * 7L);
        while(k > 1) {
            Long num = pq.poll();
            k--;
            if (visited.add(num * 3)) {
                pq.offer(3 * num);
            }
            if (visited.add(num * 5)) {
                pq.offer(5 * num);
            }
            if (visited.add(num * 7)) {
                pq.offer(7 * num);
            }
        }
        return pq.peek();
    }
}
