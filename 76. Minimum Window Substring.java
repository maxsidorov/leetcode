// With small help
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> targetMap = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            Integer count = targetMap.get(ch);
            if (count == null) count = 0;
            targetMap.put(ch, ++count);
        }
        int completed = 0, minIndex = -1, minLength = Integer.MAX_VALUE, left = 0;
        HashMap<Character, Integer> currMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer targetCount = targetMap.get(ch);
            if (targetCount != null) {
                if (completed < t.length()) {
                    // first try to find all occurrences
                    Integer currCount = currMap.get(ch);
                    if (currCount == null) currCount = 0;
                    currMap.put(ch, ++currCount);
                    if (currCount <= targetCount) completed++;
                }
                if (completed == t.length()) {
                    // once found, try to remove occurrences from left
                    while (completed == t.length()) {
                        char chLeft = s.charAt(left++);
                        Integer targetLeftCount = targetMap.get(chLeft);
                        if (targetLeftCount != null) {
                            Integer currLeftCount = currMap.get(chLeft);
                            currMap.put(chLeft, --currLeftCount);
                            if (currLeftCount < targetLeftCount) completed--;
                        }
                    }
                        
                    // check with min
                    //System.out.println("i = " + i + ", left = " + left);
                    int length = i - left + 2;
                    if (length < minLength) {
                        minIndex = left - 1;
                        minLength = length;
                    }
                }
            }
        }
        if (minIndex == -1) return "";
        return s.substring(minIndex, minIndex + minLength);
    }
}
