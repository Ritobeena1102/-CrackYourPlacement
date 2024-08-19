import java.util.*;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // Step 1: Build the graph using a HashMap
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            adjMap.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            adjMap.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }
        
        // Step 2: Identify the starting point (element with only one adjacent)
        int start = 0;
        for (int key : adjMap.keySet()) {
            if (adjMap.get(key).size() == 1) {
                start = key;
                break;
            }
        }
        
        // Step 3: Reconstruct the array
        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        Set<Integer> visited = new HashSet<>();
        result[0] = start;
        visited.add(start);
        
        for (int i = 1; i < n; i++) {
            List<Integer> neighbors = adjMap.get(result[i - 1]);
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    result[i] = neighbor;
                    visited.add(neighbor);
                    break;
                }
            }
        }
        
        return result;
    }
}
