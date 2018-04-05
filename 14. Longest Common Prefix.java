class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder builder = new StringBuilder();
        String firstStr = strs[0];
        for (int i = 0; i < firstStr.length(); i++) {
            char ch = firstStr.charAt(i);
            for(int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (str.length() < i + 1 || str.charAt(i) != ch) {
                    return builder.toString();
                }
            }
            builder.append(ch);
        }
        return builder.toString();
    }
}
