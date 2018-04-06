class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int el: nums1) {
            if (map.containsKey(el)) {
                map.put(el, map.get(el) + 1);
            } else {
                map.put(el, 1);
            }
        }
        
        ArrayList<Integer> array = new ArrayList();
        
        for(int el: nums2) {
            Integer value = map.get(el);
            if (value != null && value > 0) {
                array.add(el);
                map.put(el, value - 1);
            }
        }
        
        return array.stream().mapToInt(i->i).toArray();
    }
}
