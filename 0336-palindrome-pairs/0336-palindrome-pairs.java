import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // Helper method to check if a string is a palindrome
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
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        
        // Build a map of each word and its index
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }
        
        // Iterate through each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            
            // Check all possible splits of the word
            for (int j = 0; j <= len; j++) {
                // Prefix and suffix split
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);
                
                // Case 1: Check if the reverse of suffix exists and prefix is a palindrome
                if (isPalindrome(prefix)) {
                    String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                    if (wordMap.containsKey(reversedSuffix) && wordMap.get(reversedSuffix) != i) {
                        result.add(List.of(wordMap.get(reversedSuffix), i));
                    }
                }
                
                // Case 2: Check if the reverse of prefix exists and suffix is a palindrome
                if (j != len && isPalindrome(suffix)) {  // Avoid double-counting the same word
                    String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                    if (wordMap.containsKey(reversedPrefix) && wordMap.get(reversedPrefix) != i) {
                        result.add(List.of(i, wordMap.get(reversedPrefix)));
                    }
                }
            }
        }
        
        return result;
    }
}
