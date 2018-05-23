class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int num: nums) {
            set.add(num);
        }
        int max = 0;
        while (set.size() > max) {
            // get random element
            int count = 1;
            int num = set.iterator().next();
            set.remove(num);
            // check consecutive to left
            int curr = num;
            while (set.remove(--curr)) {
                count++;
            }
            // check consecutive to right
            curr = num;
            while (set.remove(++curr)) {
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
