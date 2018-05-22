class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] contains = new boolean[nums.length];
        for (int el: nums) {
            if (el > 0 && el <= nums.length) {
                contains[el - 1] = true;
            }
        }
        for (int i = 0; i < contains.length; i++) {
            if (!contains[i]) return i + 1;
        }
        return contains.length + 1;
    }
}
