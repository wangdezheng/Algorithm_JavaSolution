package DynamicProgramming;

/**
 * Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.
 * <p>
 * Assumptions
 * <p>
 * n >= 2
 */

//Time: O(n ^ 2), Space: O(n)
public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        // cut[i] represents the max product when rope length is i
        int[] cut = new int[length + 1];
        cut[1] = 0;
        cut[2] = 1;
        for (int i = 3; i <= length; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                // cut at j, left length is j, right length is i - j
                // we can cut rope j into many parts or not cut, just get the max.
                max = Math.max(j * (i - j), cut[j] * (i - j));
                cut[i] = Math.max(cut[i], max);
            }
        }
        return cut[length];
    }
}
