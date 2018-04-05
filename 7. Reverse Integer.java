class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if ((result > 0 && result > Integer.MAX_VALUE / 10) 
               || (result < 0 && result < Integer.MIN_VALUE / 10)) {
                return 0;
            }
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        if (x < 0) {
            result = -result;
        }
        return result;
    }
}
