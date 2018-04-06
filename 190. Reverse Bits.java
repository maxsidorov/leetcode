public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 1; i <= 32; i++) {
            if (i > 1) {
                n >>>= 1;
                result <<= 1;
            }
            result = result | (n & 1);
        }
        return result;
    }
}
