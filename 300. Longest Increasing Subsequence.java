// I didn't solve it by myself!

// Recursion, O(2^N)  [Time Limit Exceeded]
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

// DP, O(N*N)
class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
