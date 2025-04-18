class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxProfit = 0;

        while (r < prices.length) {
            int profit = prices[r] - prices[l];
            if (profit > 0) {
                maxProfit = Math.max(profit, maxProfit);
                r++;
            } else {
                l = r;
                r++;
            }
        }
        return maxProfit;
    }
}