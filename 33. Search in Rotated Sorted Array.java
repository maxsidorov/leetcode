// Still O(N), because finding min index in loop
class Solution1 {
    public int search(int[] nums, int target) {
        int N = nums.length;
        if (N == 0) return -1;
        int minIndex = getMinIndex(nums);
        int left = minIndex, right = minIndex + nums.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid % N] == target) return mid % N;
            if (nums[mid % N] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
        
    }
    
    private int getMinIndex(int[] nums) {
        int minIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[minIndex]) {
                return i;
            }
        }
        return minIndex;
    }
}

// O(LogN) now
class Solution2 {
    public int search(int[] nums, int target) {
        int N = nums.length;
        if (N == 0) return -1;
        int minIndex = getMinIndex(nums);
        System.out.println(minIndex);
        int left = minIndex, right = minIndex + nums.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid % N] == target) return mid % N;
            if (nums[mid % N] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
        
    }
    
    private int getMinIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (nums[left] > nums[right]) {
            int mid = (left + right)/2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
