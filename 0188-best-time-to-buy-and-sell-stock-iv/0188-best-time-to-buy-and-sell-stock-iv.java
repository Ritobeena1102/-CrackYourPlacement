class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        if (n == 0) return 0;
        
        // If k is large enough, it's equivalent to unlimited transactions
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        
        // DP array to store maximum profit up to day i with at most j transactions
        int[][] dp = new int[k + 1][n];
        
        for (int t = 1; t <= k; t++) {
            int maxProfitPrevious = -prices[0]; // To track the maximum profit of (t-1) transactions
            for (int d = 1; d < n; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxProfitPrevious);
                maxProfitPrevious = Math.max(maxProfitPrevious, dp[t - 1][d] - prices[d]);
            }
        }
        
        return dp[k][n - 1];
    }
}
