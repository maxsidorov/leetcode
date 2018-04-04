class Solution {
    public String longestPalindrome(String s) {
        int maxLeft = 0;
        int max = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int curr = findMaxPalindromeLength(s, i, i);
            if (curr > max) {
                maxLeft = i - curr / 2;
                max = curr;
            }
            
            if (s.charAt(i) == s.charAt(i + 1)) {
                curr = findMaxPalindromeLength(s, i, i + 1);
                if (curr > max) {
                    System.out.println("max = " + curr + ", i = " + i);
                    maxLeft = i - curr / 2 + 1;
                    max = curr;
                }
            }
        }
        System.out.println("maxLeft = " + maxLeft + ", max = " + max);
        return s.substring(maxLeft, maxLeft + max);
    }
    
    private int findMaxPalindromeLength(String s, int left, int right) {
        int curr = right - left + 1;
        while (left > 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
            curr += 2;
            left--;
            right++;
        }
        return curr;
    }
}
