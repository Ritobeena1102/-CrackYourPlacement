class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] numsExtended = new int[n + 2];
        numsExtended[0] = 1;
        numsExtended[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            numsExtended[i + 1] = nums[i];
        }
        
        int[][] dp = new int[n + 2][n + 2];
        
        // Build the DP table
        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length + 1;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + numsExtended[i] * numsExtended[k] * numsExtended[j]);
                }
            }
        }
        
        return dp[0][n + 1];
    }
}
