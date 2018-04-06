class Solution {
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        ArrayList<Integer> list = new ArrayList(nums.length);
        for(int num: nums) {
            list.add(num);
        }
        Random rand = new Random();
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = rand.nextInt(list.size());
            result[i] = list.get(index);
            list.set(index, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
