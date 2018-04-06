class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> visitedOnce = new LinkedHashMap();
        Set<Character> visitedTwice = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!visitedTwice.contains(ch)) {
                if (!visitedOnce.containsKey(ch)) {
                    visitedOnce.put(ch, i);
                } else {
                    visitedOnce.remove(ch);
                    visitedTwice.add(ch);
                }
            }
        }
        if (visitedOnce.isEmpty()) {
            return -1;
        } else {
            return visitedOnce.values().iterator().next();
        }
    }
}
