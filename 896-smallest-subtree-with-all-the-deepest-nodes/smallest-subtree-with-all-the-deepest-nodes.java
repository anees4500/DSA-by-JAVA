class Solution {

    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    TreeNode ans = null;

    public void answer(TreeNode root, int maxHeight) {
        if (root == null) return;

        int leftH = height(root.left);
        int rightH = height(root.right);

        // SAME LOGIC but correct check
        if (leftH == rightH && leftH == maxHeight - 1) {
            ans = root;
            return;
        }

        // deeper side me jao
        if (leftH > rightH) {
            answer(root.left, maxHeight - 1);
        } else {
            answer(root.right, maxHeight - 1);
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int h = height(root);
        answer(root, h);
        return ans;
    }
}
