import java.util.PriorityQueue;
import java.util.HashMap;

class Solution {
    public String reorganizeString(String s) {
        // Frequency map to store the count of each character
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Max-heap to store characters by their frequency
        PriorityQueue<CharCount> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        for (char c : freqMap.keySet()) {
            maxHeap.offer(new CharCount(c, freqMap.get(c)));
        }

        // Resultant string
        StringBuilder result = new StringBuilder();
        
        // Previous character and its frequency
        CharCount prev = new CharCount('#', 0);

        while (!maxHeap.isEmpty()) {
            CharCount current = maxHeap.poll();
            result.append(current.ch);
            
            // If there was a previous character waiting to be reinserted, put it back into the heap
            if (prev.count > 0) {
                maxHeap.offer(prev);
            }

            // Update current character's count and set it as the previous character for the next round
            current.count--;
            prev = current;
        }

        // If the length of the result is not equal to the length of the input string, it's impossible
        return result.length() == s.length() ? result.toString() : "";
    }
    
    // Helper class to store character and its frequency
    private static class CharCount {
        char ch;
        int count;

        CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
