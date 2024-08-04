import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        // A set of sets to store possible jump lengths to each stone
        Set<Integer>[] dp = new HashSet[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashSet<>();
        }
        
        // Initial state: the frog starts at the first stone with a jump length of 0
        dp[0].add(0);
        
        // Iterate over each stone
        for (int i = 0; i < n; i++) {
            for (int k : dp[i]) {
                // Check for jumps k - 1, k, and k + 1
                for (int jump = k - 1; jump <= k + 1; jump++) {
                    if (jump > 0) {
                        int nextStone = stones[i] + jump;
                        // Check if nextStone exists in the stones array
                        for (int j = i + 1; j < n; j++) {
                            if (stones[j] == nextStone) {
                                dp[j].add(jump);
                            } else if (stones[j] > nextStone) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        // The frog can cross if the last stone has any possible jump length
        return !dp[n - 1].isEmpty();
    }
}
