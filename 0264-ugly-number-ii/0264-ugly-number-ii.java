import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int nthUglyNumber(int n) {
        // Min-heap to store the ugly numbers
        PriorityQueue<Long> heap = new PriorityQueue<>();
        // Set to keep track of numbers that have been added to the heap
        Set<Long> seen = new HashSet<>();
        
        // Initialize the heap with the first ugly number
        heap.offer(1L);
        seen.add(1L);
        
        // Variables for prime factors
        long[] primes = {2, 3, 5};
        
        // Variable to hold the current ugly number
        long current = 1;
        
        for (int i = 0; i < n; i++) {
            // Extract the smallest number from the heap
            current = heap.poll();
            
            // Generate new ugly numbers by multiplying with 2, 3, and 5
            for (long prime : primes) {
                long nextUgly = current * prime;
                if (seen.add(nextUgly)) {
                    heap.offer(nextUgly);
                }
            }
        }
        
        return (int) current;
    }
}
