class Solution {
    int ans = -1;
    int count = 0;

    public void smallest(TreeNode root, int k) {
        if (root == null) return;

        smallest(root.left, k);

        count++;
        if (count == k) {
            ans = root.val;
            return;
        }

        smallest(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        smallest(root, k);
        return ans;
    }
}