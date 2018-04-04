class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            System.out.println("i = " + i);
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1, right = nums.length - 1;
            do {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    List<Integer> line = new ArrayList();
                    line.add(nums[i]);
                    line.add(nums[left]);
                    line.add(nums[right]);
                    result.add(line);
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                } else {
                    if (-nums[i] < nums[left] + nums[right]) {
                        right--;
                    } else {
                        left++;
                    }
                }
            } while (left < right);
        }
        return result;
    }
    
}
