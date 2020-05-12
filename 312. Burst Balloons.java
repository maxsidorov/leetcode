class Solution {
  public int maxCoins(int[] nums) {
    Integer[][] memo = new Integer[nums.length][nums.length];
    return maxCoinsImpl(memo, nums, -1, nums.length);
  }
  
  private int maxCoinsImpl(Integer[][] memo, int[] nums, int left, int right) {
    if (left + 1 == right) return 0;
    if (memo[left + 1][right - 1] != null) return memo[left + 1][right - 1];
    int result = 0;
    for (int i = left + 1; i < right; i++) {
      result = Math.max(result, getNum(nums, left) * getNum(nums, i) * getNum(nums, right)
        + maxCoinsImpl(memo, nums, left, i) + maxCoinsImpl(memo, nums, i, right));
    }
    memo[left + 1][right - 1] = result;
    return result;
  }
  
  private int getNum(int nums[], int index) {
    return (index == -1 || index == nums.length) ? 1 : nums[index];
  }
  
}
