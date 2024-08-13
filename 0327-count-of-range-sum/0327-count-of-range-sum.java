import java.util.*;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
        // Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        return mergeSort(prefix, 0, n + 1, lower, upper);
    }
    
    private int mergeSort(long[] prefix, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }
        
        int mid = (start + end) / 2;
        int count = mergeSort(prefix, start, mid, lower, upper) + 
                    mergeSort(prefix, mid, end, lower, upper);
        
        // Merge step
        int j = mid;
        int k = mid;
        int l = mid;
        
        for (int i = start; i < mid; i++) {
            // Count the number of valid ranges
            while (j < end && prefix[j] - prefix[i] < lower) {
                j++;
            }
            while (k < end && prefix[k] - prefix[i] <= upper) {
                k++;
            }
            count += k - j;
        }
        
        // Merge the two sorted halves
        long[] sorted = new long[end - start];
        int index1 = start, index2 = mid, index = 0;
        
        while (index1 < mid && index2 < end) {
            if (prefix[index1] <= prefix[index2]) {
                sorted[index++] = prefix[index1++];
            } else {
                sorted[index++] = prefix[index2++];
            }
        }
        
        while (index1 < mid) {
            sorted[index++] = prefix[index1++];
        }
        
        while (index2 < end) {
            sorted[index++] = prefix[index2++];
        }
        
        System.arraycopy(sorted, 0, prefix, start, sorted.length);
        
        return count;
    }
}
