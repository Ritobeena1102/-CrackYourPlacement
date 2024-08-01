import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack;

    // Constructor to initialize the iterator with the root of the BST
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root); // Initialize the stack with the leftmost path of the tree
    }

    // Helper function to push all left children of a node onto the stack
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // Returns true if there is a next smallest number
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Returns the next smallest number and moves the pointer
    public int next() {
        if (!hasNext()) {
            throw new RuntimeException("No more elements");
        }

        TreeNode node = stack.pop(); // Pop the top node
        int result = node.val; // Get the value of the node

        // If the popped node has a right child, push all its left children
        if (node.right != null) {
            pushLeft(node.right);
        }

        return result;
    }
}
