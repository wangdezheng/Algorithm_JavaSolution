package Array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge K sorted array into one big sorted array in ascending order.

    Assumptions:
        The input arrayOfArrays is not null, none of the arrays is null either.
 */

//Time:O(n), Space: O(n)
//K-way merge
public class MergeKSortedArray {
    public int[] merge(int[][] arrayOfArrays) {
        PriorityQueue<Entry> minHeap = new PriorityQueue<>(new Comparator<Entry>() {
            @Override
            public int compare(Entry e1, Entry e2) {
                if (e1.value == e2.value) {
                    return 0;
                }
                return e1.value < e2.value ? -1 : 1;
            }
        });
        int len = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            if (arrayOfArrays[i].length > 0) {
                minHeap.offer(new Entry(i, 0, arrayOfArrays[i][0]));
                len += arrayOfArrays[i].length;
            }

        }
        int[] result = new int[len];
        int cur = 0;
        while (!minHeap.isEmpty()) {
            Entry min = minHeap.poll();
            result[cur++] = min.value;
            if (++min.y < arrayOfArrays[min.x].length) {
                minHeap.offer(new Entry(min.x, min.y, arrayOfArrays[min.x][min.y]));
            }
        }
        return result;
    }

    class Entry {
        int x;
        int y;
        int value;

        Entry(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
