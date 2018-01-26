package Probability;

/**
 * Given an array of integers (without any duplicates), shuffle the array such that all permutations are equally likely to be generated.
 */

//Time: O(n), Space: O(1)
public class PerfectShuffle {
    public void shuffle(int[] array) {
        if (array == null) {
            return;
        }
        int len = array.length;
        for (int i = len - 1; i >= 1; i--) {
            int randomIndex = (int) (Math.random() * (i + 1));
            swap(array, randomIndex, i);
        }
    }
    private void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
