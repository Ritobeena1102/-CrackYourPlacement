class Solution {
    public int superEggDrop(int k, int n) {
        // Initialize the DP table
        int[][] dp = new int[k + 1][n + 1];
        
        // Fill the table
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    // If there is only one egg, we need to drop it from every floor
                    dp[i][j] = j;
                } else {
                    // We use binary search to find the minimum number of moves
                    int low = 1, high = j;
                    while (low + 1 < high) {
                        int mid = low + (high - low) / 2;
                        if (dp[i - 1][mid - 1] < dp[i][j - mid]) {
                            low = mid;
                        } else {
                            high = mid;
                        }
                    }
                    dp[i][j] = 1 + Math.min(Math.max(dp[i - 1][low - 1], dp[i][j - low]),
                                           Math.max(dp[i - 1][high - 1], dp[i][j - high]));
                }
            }
        }
        
        return dp[k][n];
    }
}
