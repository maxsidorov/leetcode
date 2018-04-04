class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> value = map.get(key);
            if (value == null) {
                value = new ArrayList<String>();
                map.put(key, value);
            }
            value.add(str);
        }
        return new ArrayList(map.values());
    }
}
