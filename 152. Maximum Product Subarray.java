class Solution {
  public int maxProduct(int[] nums) {
    int max = nums[0], min = nums[0], result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int currMax = max;
      max = Math.max(nums[i], Math.max(nums[i] * currMax, nums[i] * min));
      min = Math.min(nums[i], Math.min(nums[i] * currMax, nums[i] * min));
      result = Math.max(result, max);
    }
    return result;
  }
}
