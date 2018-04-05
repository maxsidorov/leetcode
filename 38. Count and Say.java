class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            char ch = result.charAt(0);
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == ch) {
                    count++;
                } else {
                    builder.append(count).append(ch);
                    ch = result.charAt(j);
                    count = 1;
                }
            }
            builder.append(count).append(ch);
            result = builder.toString();
        }
        return result;
    }
}
