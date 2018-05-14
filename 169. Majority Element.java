class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int el: nums) {
            Integer count = map.get(el);
            if (count == null) {
                count = 0;
            }
            count++;
            map.put(el, count);
            if (count > max) {
                max = count;
                majority = el;
            }
        }
        return majority;
    }
}
