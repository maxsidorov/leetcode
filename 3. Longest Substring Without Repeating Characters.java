class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        int max = 0;
        HashMap<Character, Integer> map = new HashMap();
        
        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                max = Math.max(max, map.size());
                
                do {
                    map.remove(s.charAt(j));
                } while (s.charAt(j++) != ch);
            }
            map.put(ch, i);
        }
        max = Math.max(max, map.size());
        
        return max;
    }
}

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        int max = 0;
        HashMap<Character, Integer> map = new HashMap();
        
        for (int i = 0, j = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                j = Math.max(j, map.get(ch) + 1);
            }
            max = Math.max(max, i - j + 1);
            map.put(ch, i);
        }
        
        return max;
    }
}
