import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        // Sort the array to handle duplicates
        Arrays.sort(nums);
        // Start the backtracking process
        backtrack(nums, new boolean[nums.length], currentPermutation, result);
        return result;
    }

    // Backtracking function to generate permutations
    private void backtrack(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result) {
        // Base case: if the current permutation is of the same length as nums, add it to the result
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements
            if (used[i]) continue;
            // Skip duplicates: if the current element is the same as the previous element and the previous element was not used, skip it
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // Choose the current element
            used[i] = true;
            currentPermutation.add(nums[i]);
            // Recur to build the permutation
            backtrack(nums, used, currentPermutation, result);
            // Backtrack: remove the current element and mark it as unused
            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }
}
