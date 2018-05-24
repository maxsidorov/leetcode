// First solution [Stack Overflow]
class Solution1 {
    public int calculate(String s) {
        int opIndex = indexOfNextOperation(s, 0);
        return calculateHelper(parseValue(s, 0, opIndex), s, opIndex);
    }
    
    private int calculateHelper(int left, String s, int opIndex) {
        if (opIndex == -1) return left;
        char op = s.charAt(opIndex);
        
        int nextOpIndex = indexOfNextOperation(s, opIndex + 1);
        int right = parseValue(s, opIndex + 1, nextOpIndex);
        
        if (op == '+') {
            return left + calculateHelper(right, s, nextOpIndex);
        }
        if (op == '-') {
            return left - calculateHelper(right, s, nextOpIndex);
        }
        if (op == '*') {
            return calculateHelper(left * right, s, nextOpIndex);
        }
        if (op == '/') {
            return calculateHelper(left / right, s, nextOpIndex);
        }
        return -1;
    }
    
    private int indexOfNextOperation(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                return i;
            }
        }
        return -1;
    }
    
    private int parseValue(String s, int start, int nextOpIndex) {
        if (nextOpIndex > -1) {
            return Integer.valueOf(s.substring(start, nextOpIndex).trim());
        } else {
            return Integer.valueOf(s.substring(start).trim());
        }
    }
}

// Iterative, no stack solution [Accepted]
class Solution2 {
    public int calculate(String s) {
        int opIndex = indexOfNextOperation(s, 0);
        int result = 0;
        int mult = parseValue(s, 0, opIndex);
        while (opIndex > -1) {
            char op = s.charAt(opIndex);
            int nextOpIndex = indexOfNextOperation(s, opIndex + 1);
            int right = parseValue(s, opIndex + 1, nextOpIndex);
            
            if (op == '+' || op == '-') {
                result += mult;
                mult = right;
                if (op == '-') mult = -mult;
            } else {
                if (op == '*') {
                    mult *= right;
                } else {
                    mult /= right;
                }
            }
            opIndex = nextOpIndex;
        }
        return result + mult;
    }
    
    private int indexOfNextOperation(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                return i;
            }
        }
        return -1;
    }
    
    private int parseValue(String s, int start, int nextOpIndex) {
        if (nextOpIndex > -1) {
            return Integer.valueOf(s.substring(start, nextOpIndex).trim());
        } else {
            return Integer.valueOf(s.substring(start).trim());
        }
    }
}
