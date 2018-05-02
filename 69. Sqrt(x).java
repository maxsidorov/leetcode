// My solution, Log N
class Solution {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) return x;
        float prev = -1, curr = x/2, len = x/2;
        while (Math.abs(prev - curr) > 0.1) {
            prev = curr;
            len /= 2;
            if (curr * curr > x) {
                curr -= len;
            } else {
                curr += len;
            }
        }
        int max = (int)Math.max(curr, prev);
        // 46340 - is sqrt from Integer.MAX_VALUE
        if (max < 46340 && (max + 1) * (max + 1) <= x) return max + 1;
        if (max * max <= x) return max;
        return max - 1;
    }
}
