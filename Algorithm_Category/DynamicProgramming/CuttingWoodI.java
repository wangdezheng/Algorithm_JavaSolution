package DynamicProgramming;

/**
 *There is a wooden stick with length L >= 1, we need to cut it into pieces, where the cutting positions are defined in an int array A.
  The positions are guaranteed to be in ascending order in the range of [1, L - 1]. The cost of each cut is the length of the stick segment being cut.
  Determine the minimum total cost to cut the stick into the defined pieces.

 Examples:
    L = 10, A = {2, 4, 7}, the minimum total cost is 10 + 4 + 6 = 20 (cut at 4 first then cut at 2 and cut at 7)
 */

//Time: O(n ^ 3), Space: O(n ^ 2)
//Every time we need to choose each possible value of i and j, we also need to iterate each possible value between i and j to get the minimum cost
public class CuttingWoodI {
    public int minCost(int[] cuts, int length) {
        if (cuts == null || cuts.length == 0) {
            return 0;
        }

        //create newCut to add value 0, length into it
        int [] newCut = new int[cuts.length + 2];
        int len = newCut.length;
        newCut[0] = 0;
        newCut[len - 1] = length;
        for (int i = 1; i < len - 1; i++) {
            newCut[i] = cuts[i - 1];
        }

        //cost[i][j] represents the min cost of cut between index i and j
        int[][] cost = new int[len][len];
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (i == j - 1) {
                    cost[i][j] = 0;
                } else {
                    cost[i][j] = Integer.MAX_VALUE;
                    for (int k = i + 1; k <= j - 1; k++) {
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                    }
                    cost[i][j] += newCut[j] - newCut[i];
                }
            }
        }
        return cost[0][len - 1];
    }
}
