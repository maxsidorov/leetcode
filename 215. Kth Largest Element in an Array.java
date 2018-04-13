// 1 - Sort O(N*logN)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// 2 - Max heap  O(N*logK)
