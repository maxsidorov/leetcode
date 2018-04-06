class Solution {
    public boolean isPalindrome(String s) {
        
        if (s.length() == 0) return true;
        
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);
            
            if (!Character.isLetterOrDigit(leftCh)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightCh)) {
                right--;
            } else if (Character.toLowerCase(leftCh) != Character.toLowerCase(rightCh)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        
        return true;
    }
}
