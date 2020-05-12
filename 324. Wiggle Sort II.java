class Solution {
    public void wiggleSort(int[] nums) {
      int[] buffer = Arrays.copyOf(nums, nums.length);
      Arrays.sort(buffer);
      for(int i = 0; i < nums.length; i++) {
        nums[i] = (i % 2 == 0)
          ? buffer[(nums.length + 1) / 2 - 1 - i / 2]
          : buffer[nums.length  - 1 - i / 2];
      }
    }
}
