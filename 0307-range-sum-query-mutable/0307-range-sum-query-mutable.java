class NumArray {
    private int[] nums;
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[4 * n];
        buildTree(0, 0, n - 1);
    }
    
    private void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
        } else {
            int mid = (start + end) / 2;
            buildTree(2 * node + 1, start, mid);
            buildTree(2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }
    
    public void update(int index, int val) {
        updateTree(0, 0, n - 1, index, val);
    }
    
    private void updateTree(int node, int start, int end, int index, int val) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = (start + end) / 2;
            if (start <= index && index <= mid) {
                updateTree(2 * node + 1, start, mid, index, val);
            } else {
                updateTree(2 * node + 2, mid + 1, end, index, val);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }
    
    public int sumRange(int left, int right) {
        return queryTree(0, 0, n - 1, left, right);
    }
    
    private int queryTree(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftSum = queryTree(2 * node + 1, start, mid, left, right);
        int rightSum = queryTree(2 * node + 2, mid + 1, end, left, right);
        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index, val);
 * int param_2 = obj.sumRange(left, right);
 */
