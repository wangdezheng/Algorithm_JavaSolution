package HashTableAndString;

/**
 给定一个包含 [0, n]中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

 仅使用线性时间复杂度、额外常数空间的算法解决此问题

 示例 1：
     输入：nums = [3,0,1]
     输出：2
     解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。

 示例 2：
     输入：nums = [0,1]
     输出：2
     解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。

 Assumptions:
     n == nums.length
     1 <= n <= 104
     0 <= nums[i] <= n
     nums 中的所有数字都独一无二
 */
// Time: O(n), Space: O(1)
// Any number XOR itself equals 0; Any number XOR 0 equals itself; (2 ^ 2 == 0,  2 ^ 0 == 2)
public class MissingNumber {
   public int missingNumber(int[] nums) {
       int result = 0;
       for (int i = 0; i < nums.length; i++) {
           result = result ^ i ^ nums[i];
       }
       return result ^ nums.length;
   }
}
