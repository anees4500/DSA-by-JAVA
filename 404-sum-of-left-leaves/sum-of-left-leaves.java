 class Solution {
    public int helper(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;

        // check if left child is a leaf
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        // recurse for left and right subtrees
        sum += helper(root.left);
        sum += helper(root.right);

        return sum;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root);
    }
}
