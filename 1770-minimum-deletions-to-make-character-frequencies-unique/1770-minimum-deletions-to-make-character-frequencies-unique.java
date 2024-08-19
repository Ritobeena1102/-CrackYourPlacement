import java.util.*;

class Solution {
    public int minDeletions(String s) {
        // Step 1: Count frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Track used frequencies and count deletions
        Set<Integer> usedFreq = new HashSet<>();
        int deletions = 0;

        for (int f : freq) {
            while (f > 0 && usedFreq.contains(f)) {
                f--;  // Reduce frequency to avoid collision
                deletions++;  // Count as a deletion
            }
            usedFreq.add(f);
        }

        return deletions;
    }
}
