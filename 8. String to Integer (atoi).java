class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean isPositive = true;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            if (str.charAt(0) == '-') {
                isPositive = false;
            }
            str = str.substring(1);
        }
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int num = ch - '0';
                int prev_value = result;
                result = result * 10 + num;
                if (result < 0 || (result - num)/10 != prev_value) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        
        // if (result == Integer.MAX_VALUE && !isPositive) {
        //     return Integer.MAX_VALUE;
        // }

        return isPositive ? result : -result;
    }
}
