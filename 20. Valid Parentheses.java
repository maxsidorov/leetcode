class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return false;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' | ch == '{' | ch == '[' ) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char ch2 = stack.pop();
                if (ch == ')' && ch2 != '(') return false;
                if (ch == '}' && ch2 != '{') return false;
                if (ch == ']' && ch2 != '[') return false;
            }
        }
        return stack.isEmpty();
        
    }
}
