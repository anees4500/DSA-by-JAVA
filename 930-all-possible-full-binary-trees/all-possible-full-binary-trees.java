 class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n % 2 == 0) return ans; // full binary tree only possible for odd n
        if (n == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }

        for (int left = 1; left < n; left += 2) {
            int right = n - 1 - left;
            for (TreeNode l : allPossibleFBT(left)) {
                for (TreeNode r : allPossibleFBT(right)) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }

        return ans;
    }
}
