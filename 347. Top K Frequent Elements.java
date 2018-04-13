class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // create num to count map
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }
        
        // create buckets for each count
        List<Integer>[] buckets = new List[max];
        map.forEach((num, count) -> {
            if (buckets[count - 1] == null) {
                buckets[count - 1] = new ArrayList();
            }
            buckets[count - 1].add(num);
        });
        
        // take top K frequent nums
        List<Integer> result = new ArrayList(k);
        for (int i = max - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
                if (result.size() >= k) {
                    break;
                }
            }
        }
        
        return result.subList(0, k);
    }
}
