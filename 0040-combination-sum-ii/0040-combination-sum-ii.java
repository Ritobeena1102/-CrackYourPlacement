import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates and simplify combination generation
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> combination, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break; // No need to continue if the candidate exceeds the target
            }
            combination.add(candidates[i]);
            // Recur with the updated target and next index
            backtrack(result, combination, candidates, target - candidates[i], i + 1);
            combination.remove(combination.size() - 1); // Backtrack
        }
    }
}
