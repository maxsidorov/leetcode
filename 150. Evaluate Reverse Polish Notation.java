class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String token: tokens) {
            switch (token) {
                case "+": {
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    stack.push(val1 + val2);
                    break;
                }
                case "*": {
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    stack.push(val1 * val2);
                    break;
                }
                case "-": {
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    stack.push(val1 - val2);
                    break;
                }
                case "/": {
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    stack.push(val1 / val2);
                    break;
                }
                default: {
                    int val = Integer.valueOf(token);
                    stack.push(val);
                    break;
                }
            }
        }
        return stack.pop();
    }
}
