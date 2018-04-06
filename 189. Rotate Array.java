class Solution {
    public void rotate(int[] nums, int k) {
         k %= nums.length;
        rotate(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        rotate(nums, 0, k -1);
        System.out.println(Arrays.toString(nums));
        rotate(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    
    private void rotate(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}
