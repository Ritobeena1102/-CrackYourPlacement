import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // Min-heap to store elements along with their row and column indices
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        
        // Initialize the heap with the first element of each row
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Element(matrix[i][0], i, 0));
        }
        
        // Extract the smallest element k times
        for (int i = 0; i < k - 1; i++) {
            Element current = minHeap.poll();
            
            // If there is a next element in the same row, add it to the heap
            if (current.col + 1 < n) {
                minHeap.offer(new Element(matrix[current.row][current.col + 1], current.row, current.col + 1));
            }
        }
        
        // The kth smallest element
        return minHeap.poll().value;
    }
    
    // Helper class to store matrix elements along with their positions
    private static class Element {
        int value;
        int row;
        int col;
        
        Element(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
}
