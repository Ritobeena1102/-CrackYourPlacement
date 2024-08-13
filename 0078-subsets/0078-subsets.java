import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(nums, 0, currentSubset, result);
        return result;
    }

    // Recursive function to generate subsets
    private void backtrack(int[] nums, int start, List<Integer> currentSubset, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(currentSubset));
        
        // Explore further subsets
        for (int i = start; i < nums.length; i++) {
            // Add the current element to the subset
            currentSubset.add(nums[i]);
            // Recur to generate subsets including nums[i]
            backtrack(nums, i + 1, currentSubset, result);
            // Backtrack: remove the last added element
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
