class Solution {
    public int maxProfit(int[] prices) {
        int l = 0; // buy
        int r = 1; // sell
        int maxProfit = 0;

        while (r < prices.length) {
            // Is it profitable? buy low & sell high
            if (prices[l] <= prices[r]) {
                int profit = prices[r] - prices[l];
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