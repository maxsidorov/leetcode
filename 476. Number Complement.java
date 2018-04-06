class Solution {
    public int findComplement(int num) {
        Stack<Integer> bits = new Stack<Integer>();
        while (num > 0) {
            bits.push(num % 2 == 1 ? 0 : 1);
            num /= 2;
        }
        int result = 0;
        while (!bits.isEmpty()) {
            result *= 2;
            result += bits.pop();
        }
        return result;
    }
}
