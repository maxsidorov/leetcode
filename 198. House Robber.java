class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int last = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int max = Math.max(last +  nums[i], curr);
            last = curr;
            curr = max;
        }
        return Math.max(last, curr);
    }
}
