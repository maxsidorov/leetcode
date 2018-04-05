class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(target - nums[i]);
            if (value != null && value != i) {
                return new int[]{i, value};
            }
        }
        return null;
    }
}
