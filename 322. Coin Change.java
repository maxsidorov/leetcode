// DP [Time Limit Exceeded]
class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        return coinChangeHelper(coins, amount, 0);
    }
    
    public int coinChangeHelper(int[] coins, int amount, int coinIndex) {
        int min = Integer.MAX_VALUE;
        for (int i = coinIndex; i < coins.length; i++) {
            if (coins[i] == amount) return 1;
            if (coins[i] < amount) {
                int count = coinChangeHelper(coins, amount - coins[i], i);
                if (count != -1) {
                    min = Math.min(min, count + 1);
                }
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }
}

// DP + memo [Accepted]
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int memo[] = new int[amount];
        return coinChangeHelper(coins, amount, memo);
    }
    
    public int coinChangeHelper(int[] coins, int amount, int[] memo) {
        if (memo[amount - 1] != 0) return memo[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int i = coinIndex; i < coins.length; i++) {
            if (coins[i] == amount) return 1;
            if (coins[i] < amount) {
                int count = coinChangeHelper(coins, amount - coins[i], memo);
                if (count != -1) {
                    min = Math.min(min, count + 1);
                }
            }
        }
        memo[amount - 1] = min != Integer.MAX_VALUE ? min : -1;
        return memo[amount - 1];
    }
}
