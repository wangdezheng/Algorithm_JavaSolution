package Probability;

import java.util.List;

/**
 * Given a list of integers representing the lengths of urls, find the 95 percentile of all lengths (95% of the urls have lengths <= returned length).
 *
 * Assumptions:
 *      The maximum length of valid url is 4096
 *      The list is not null and is not empty and does not contain null
 *
 * Examples:
 *      [1, 2, 3, ..., 95, 96, 97, 98, 99, 100], 95 percentile of all lengths is 95.
 */
// Time: O(n), Space: O(n)
public class Percentile {
    public int percentile95(List<Integer> lengths) {
        int[] array = new int[4097];
        for (Integer i : lengths) {
            array[i]++;
        }
        double pivot = lengths.size() * 0.05;
        int i = 4097;
        int count = 0;
        while (count <= pivot) {
            count += array[--i];
        }
        return i;
    }
}
