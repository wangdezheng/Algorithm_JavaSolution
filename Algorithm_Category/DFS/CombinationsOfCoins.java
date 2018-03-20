package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.

 Arguments:
    coins - an array of positive integers representing the different denominations of coins, there are no duplicate
 numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
    target - a non-negative integer representing the target number of cents, eg. 99

 Assumptions:
    coins is not null and is not empty, all the numbers in coins are positive
    target >= 0
    You have infinite number of coins for each of the denominations, you can pick any number of the coins.

 Return:
    a list of ways of combinations of coins to sum up to be target.
    each way of combinations is represented by list of integer, the number at each index means the number of coins
 used for the denomination at corresponding index.

 Examples:
    coins = {2, 1}, target = 4, the return should be

 [
 [0, 4],   (4 cents can be conducted by 0 2 cents + 4 1 cents)
 [1, 2],   (4 cents can be conducted by 1 2 cents + 2 1 cents)
 [2, 0]    (4 cents can be conducted by 2 2 cents + 0 1 cents)
 ]
 */

//Time: O(n ^ 2), Space: O(n)
public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combinations(target, target, 0, coins, combination, result);
        return result;
    }

    private void combinations(int target, int remain, int index, int[] coins, List<Integer>  combination, List<List<Integer>> result) {
        if (index == coins.length - 1) {
            if (remain % coins[index] == 0) {
                combination.add(remain / coins[index]);
                result.add(new ArrayList<>(combination));
                combination.remove(combination.size() - 1);
            }
            return;
        }
        for (int i = 0; i <= remain / coins[index]; i++) {
            combination.add(i);
            combinations(target, remain - i * coins[index], index + 1, coins, combination, result);
            combination.remove(combination.size() -1);
        }
    }
}
