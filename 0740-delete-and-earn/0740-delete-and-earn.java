class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001; // Assuming maximum number in nums is less than 10001
        int[] sum = new int[n];
        for (int num : nums) {
            sum[num] += num;
        }

        int dp[] = new int[n];
        dp[1] = sum[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }

        return dp[n - 1];
    }
}
