class Solution {
    public String fractionToDecimal(int numeratorInput, int denominatorInput) {
        long numerator = (long)numeratorInput;
        long denominator = (long)denominatorInput;
        StringBuilder result = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            result.append("-");
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        result.append(numerator / denominator);
        if (numerator % denominator != 0) {
            numerator = numerator % denominator;
            result.append(".");
            HashMap<Long, Integer> numeratorToIndexMap = new HashMap();
            do {
                numerator *= 10;
                if (numeratorToIndexMap.containsKey(numerator)) {
                    result.insert(numeratorToIndexMap.get(numerator), "(");
                    result.append(")");
                    return result.toString();
                }
                numeratorToIndexMap.put(numerator, result.length());
                long num = numerator / denominator;
                result.append(num);
                numerator = numerator - num * denominator;
            } while (numerator % denominator != 0);
        }
        return result.toString();
    }
}
