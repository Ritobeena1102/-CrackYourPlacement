import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Min-heap to keep track of the height differences where ladders are used
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Iterate through the buildings
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            
            // If the height difference is positive, we need either bricks or a ladder
            if (diff > 0) {
                minHeap.offer(diff); // Add the height difference to the heap
                
                // If we have used more ladders than available, use bricks for the smallest difference
                if (minHeap.size() > ladders) {
                    bricks -= minHeap.poll(); // Use bricks for the smallest height difference
                }
                
                // If we run out of bricks, we cannot proceed further
                if (bricks < 0) {
                    return i;
                }
            }
        }
        
        // If we successfully process all buildings
        return heights.length - 1;
    }
}
