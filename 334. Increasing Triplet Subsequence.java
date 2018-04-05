class Solution1 {
    public boolean increasingTriplet(int[] nums) {
        int i = 0, j = 0, min = 0;
        for (int n = 1; n < nums.length; n++) {
            if (i == j) {
                if (nums[n] < nums[i]) {
                    i = n;
                    j = n;
                }
                if (nums[n] > nums[i]) {
                    j = n;
                }
                
            } else {
                if (nums[n] > nums[j]) {
                    return true;
                }
                if (nums[n] < nums[j] && nums[n] > nums[i]) {
                    j = n;
                }
                if (nums[n] < nums[j] && min > i) {
                    i = min;
                    j = n;
                }
            }
            if (nums[n] < nums[min]) {
                min = n;
            }
            System.out.println("n = " + n + ", i = " + i + ", j = " + j + ", min = " + min);
        }
        return false;
    }
}


class Solution2 {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, middle = Integer.MAX_VALUE;
        for (int el: nums) {
            if (el <= small) {
                small = el;
            } else if (el <= middle) {
                middle = el;
            } else {
                return true;
            }
        }
        return false;
    }
}
