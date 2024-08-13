import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        backtrack(s, 0, currentPartition, result);
        return result;
    }

    // Recursive function to perform backtracking
    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        // If we've reached the end of the string, add the current partition to the result
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // Try all possible substrings starting from index 'start'
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                currentPartition.add(substring);
                // Recur to find the next partition
                backtrack(s, end, currentPartition, result);
                // Backtrack: remove the last added substring
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    // Helper function to check if a substring is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
