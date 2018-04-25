// I didn't solve it by myself!

// Recursion, O (N^2)  [Time Limit Exceeded]
class Solution1 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        return lengthOfLISHelper(nums, 0, Integer.MIN_VALUE);
    }
    
    public int lengthOfLISHelper(int[] nums, int index, int currMax) {
        if (index == nums.length) return 0;
        int result = lengthOfLISHelper(nums, index + 1, currMax);
        if (nums[index] > currMax) {
            result = Math.max(result, 1 + lengthOfLISHelper(nums, index + 1, nums[index]));
        }
        return result;
    }
}

