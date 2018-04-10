class Solution1 {
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return Arrays.asList("()");
        } else {
            Set<String> result = new HashSet<String>();
            List<String> tails =  generateParenthesis(n - 1);
            for (String tail: tails) {
                for (int i = 0; i < tail.length(); i++) {
                    String s = "(" + tail.substring(0, i) + ")" + tail.substring(i);
                    result.add(s);
                }
            }
            return new ArrayList<String>(result);
        }
    }
}


class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        generateParenthesis(result, "", n, 0, 0);
        return result;
    }
    
    private void generateParenthesis(List<String> result, String s, int n, int openCount, int closeCount) {
        if (s.length() == n * 2) {
            result.add(s);
        } else {
            if (openCount < n) {
                generateParenthesis(result, s + "(", n, openCount + 1, closeCount);
            }
            if (closeCount < openCount) {
                generateParenthesis(result, s + ")", n, openCount, closeCount + 1);
            }
        }
    }
}
