import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to keep the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Process each number in the array
        for (int num : nums) {
            minHeap.offer(num); // Add the number to the heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element if heap size exceeds k
            }
        }
        
        // The root of the heap is the kth largest element
        return minHeap.peek();
    }
}
