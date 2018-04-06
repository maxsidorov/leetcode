class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int el: nums) {
            if (set.contains(el)) {
                set.remove(el);
            } else {
                set.add(el);
            }
        }
        return set.iterator().next();
    }
}
