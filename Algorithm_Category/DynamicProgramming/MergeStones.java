package DynamicProgramming;

/**
 * We have a list of piles of stones, each pile of stones has a certain weight, represented by an array of integers.
 * In each move, we can merge two adjacent piles into one larger pile, the cost is the sum of the weights of the two piles.
 * We merge the piles of stones until we have only one pile left. Determine the minimum total cost.

 Assumptions:
    stones is not null and is length of at least 1

 Examples:
    {4, 3, 3, 4}, the minimum cost is 28
    merge first 4 and first 3, cost 7
    merge second 3 and second 4, cost 7
    merge two 7s, cost 14
    total cost = 7 + 7 + 14 = 28
 */
//Time: O(n ^ 3), Space: O(n ^ 2)
public class MergeStones {
    public static int minCost(int[] stones) {
        int len = stones.length;
        //minCost[i][j] represents the min cost to merge stones between index i and j
        int[][] minCost = new int[len][len];
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                minCost[i][j] = Integer.MAX_VALUE;
                for (int k = i ; k < j; k++) {
                    minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k + 1][j]);
                }
                //We need to add each pile of stone between index i and j to get the final result
                for (int m = i; m <= j; m++) {
                    minCost[i][j] += stones[m];
                }
            }
        }
        return minCost[0][len - 1];
    }
}
