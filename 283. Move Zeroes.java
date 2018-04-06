class Solution {
    public void moveZeroes(int[] nums) {
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[target] = nums[i];
            if (nums[i] != 0) {
                target++;
            }
        }
        while(target < nums.length) {
            nums[target++] = 0;
        }
    }
}
