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
