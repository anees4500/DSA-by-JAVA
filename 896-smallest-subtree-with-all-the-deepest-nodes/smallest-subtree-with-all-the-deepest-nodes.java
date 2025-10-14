 class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = getMaxDepth(root);
        List<TreeNode> deepestNodes = new ArrayList<>();
        collectDeepest(root, 0, maxDepth, deepestNodes);

        // case 1: only one deepest node
        if (deepestNodes.size() == 1) {
            return deepestNodes.get(0);
        }

        // case 2: multiple deepest nodes -> find their LCA
        return findLCA(root, deepestNodes);
    }

    // Step 1: find max depth
    private int getMaxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }

    // Step 2: collect all nodes at max depth
    private void collectDeepest(TreeNode root, int depth, int maxDepth, List<TreeNode> list) {
        if (root == null) return;
        if (depth + 1 == maxDepth) list.add(root);
        collectDeepest(root.left, depth + 1, maxDepth, list);
        collectDeepest(root.right, depth + 1, maxDepth, list);
    }

    // Step 3: find LCA for multiple nodes
    private TreeNode findLCA(TreeNode root, List<TreeNode> nodes) {
        if (root == null || nodes.contains(root)) return root;

        TreeNode left = findLCA(root.left, nodes);
        TreeNode right = findLCA(root.right, nodes);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
