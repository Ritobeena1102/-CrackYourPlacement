class Solution {
    public int countArrangement(int n) {
        // This array will keep track of which numbers have been used
        boolean[] used = new boolean[n + 1];
        // Start the backtracking with the initial position set to 1
        return backtrack(1, n, used);
    }
    
    // Helper method to count arrangements using backtracking
    private int backtrack(int pos, int n, boolean[] used) {
        // Base case: if we've filled all positions, we have a valid arrangement
        if (pos > n) {
            return 1;
        }
        
        int count = 0;
        // Try placing each number in the current position
        for (int num = 1; num <= n; num++) {
            if (!used[num] && (num % pos == 0 || pos % num == 0)) {
                used[num] = true; // Mark this number as used
                count += backtrack(pos + 1, n, used); // Recurse for the next position
                used[num] = false; // Unmark this number (backtrack)
            }
        }
        return count;
    }
}
