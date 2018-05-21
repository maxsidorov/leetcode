class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map1 = buildSumMap(A, B);
        HashMap<Integer, Integer> map2 = buildSumMap(C, D);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: map1.entrySet()) {
            Integer foundCount = map2.get(-entry.getKey());
            if (foundCount != null) {
                count += foundCount * entry.getValue();
            }
        }
        return count;
    }
    
    private HashMap<Integer, Integer> buildSumMap(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int a: A) {
            for (int b: B) {
                int sum = a + b;
                Integer count = map.get(sum);
                if (count == null) count = 0;
                map.put(sum, ++count);
            }
        }
        return map;
    }
}
