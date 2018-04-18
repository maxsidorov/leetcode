// Can be O(N)
class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                while (left > 0 && nums[left - 1] == target) left--;
                while (right < nums.length - 1 && nums[right + 1] == target) right++;
                return new int[]{left, right};
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}

// O(LogN)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums.length == 0 || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int resultLeft = left;

        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1)/2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        
        return new int[]{resultLeft, left};
    }
}
