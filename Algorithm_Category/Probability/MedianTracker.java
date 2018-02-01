package Probability;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an unlimited flow of numbers, keep track of the median of all elements seen so far.
 * You will have to implement the following two methods for the class
 *      read(int value) - read one value from the flow
 *      median() - return the median at any time, return null if there is no value read so far
 *
 * Examples:
 *      read(1), median is 1
 *      read(2), median is 1.5
 *      read(3), median is 2
 *      read(10), median is 2.5
 *         ......
 */

//Time: O(n), Space: O(n)
//Suppose we have one minHeap and one maxHeap, when a new element comes, we compare it with the peek of both maxHeap and minHeap,
//then we can decide where to put it. Always keep maxHeap.size() == (minHeap.size() or minHeap.size() + 1)
public class MedianTracker {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    ;

    public void read(int value) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(value);
        } else {
            if (value < maxHeap.peek()) {
                maxHeap.offer(value);
            } else {
                minHeap.offer(value);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public Double median() {
        if (maxHeap.isEmpty()) {
            return null;
        }
        if (maxHeap.size() == minHeap.size() + 1) {
            return Double.valueOf(maxHeap.peek());
        } else {
            double total = (double) maxHeap.peek() + minHeap.peek();
            return total / 2;
        }
    }
}
