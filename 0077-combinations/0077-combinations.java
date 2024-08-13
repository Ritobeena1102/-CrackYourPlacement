import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> combination, int start, int n, int k) {
        // If the combination is of size k, add it to the result
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        
        // Try adding each number from start to n
        for (int i = start; i <= n; i++) {
            combination.add(i);
            // Move to the next number with updated combination
            backtrack(result, combination, i + 1, n, k);
            // Remove last element to try the next possibility
            combination.remove(combination.size() - 1);
        }
    }
}
