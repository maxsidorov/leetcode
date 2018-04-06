class Solution {
    public int missingNumber(int[] nums) {
        int sumAll = nums.length;
        int sumNums = 0;
        for (int i = 0; i < nums.length; i++) {
            sumAll += i;
            sumNums += nums[i];
        }
        return sumAll - sumNums;
        
    }
}
