class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int num = ch - 'A' + 1;
            result = result * 26 + num;
        }
        return result;
    }
}
