class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) return 0;
    int buy = -prices[0], sell = 0, bought = -prices[0], sold = 0, buyOld, sellOld;
    for (int i = 1; i < prices.length; i++) {
      int price = prices[i];
      buyOld = buy;
      sellOld = sell;
      buy = sold - price;
      sell = Math.max(buyOld, bought) + price;
      bought = Math.max(buyOld, bought);
      sold = Math.max(sellOld, sold);
    }
    return Math.max(sell, sold);
  }

}
