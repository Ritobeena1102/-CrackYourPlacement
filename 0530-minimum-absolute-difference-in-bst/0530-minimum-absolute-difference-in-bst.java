import java.util.ArrayList;
import java.util.List;

class Solution {
    // List to store the in-order traversal of the tree
    private List<Integer> values = new ArrayList<>();
    
    public int getMinimumDifference(TreeNode root) {
        // Perform in-order traversal to get sorted values
        inorderTraversal(root);
        
        // Initialize minimum difference to a large value
        int minDiff = Integer.MAX_VALUE;
        
        // Calculate the minimum difference between adjacent values
        for (int i = 1; i < values.size(); i++) {
            minDiff = Math.min(minDiff, values.get(i) - values.get(i - 1));
        }
        
        return minDiff;
    }
    
    // Helper method for in-order traversal
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorderTraversal(node.left); // Traverse left subtree
        values.add(node.val);       // Visit node
        inorderTraversal(node.right); // Traverse right subtree
    }
}
