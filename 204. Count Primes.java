class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isNotPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isNotPrime[i - 1]) {
                for (int j = 2; j * i < n; j++) {
                    isNotPrime[j * i - 1] = true;
                }
                count++;
            }
        }
        return count;
    }
}
