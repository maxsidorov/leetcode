class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList();
        return letterCombinationsImpl(digits, 0, digits.length() - 1);
    }
    
    private List<String> letterCombinationsImpl(String digits, int left, int right) {
        if (left == right) {
            return getDigitChars(digits.charAt(left));
        } else {
            List<String> list1 = getDigitChars(digits.charAt(left));
            List<String> list2 = letterCombinationsImpl(digits, left + 1, right);
            if (list1.size() == 0) return list2;
            if (list2.size() == 0) return list1;
            List<String> result = new ArrayList();
            for (String s1: list1) {
                for (String s2: list2) {
                    result.add(s1 + s2);
                }
            }
            return result;
        }
    }
    
    private List<String> getDigitChars(char digit) {
        switch (digit) {
            case '2': return Arrays.asList("a", "b", "c");
            case '3': return Arrays.asList("d", "e", "f");
            case '4': return Arrays.asList("g", "h", "i");
            case '5': return Arrays.asList("j", "k", "l");
            case '6': return Arrays.asList("m", "n", "o");
            case '7': return Arrays.asList("p", "q", "r", "s");
            case '8': return Arrays.asList("t", "u", "v");
            case '9': return Arrays.asList("w", "x", "y", "z");
            default : return Arrays.asList();
        }
    }
}
