 class Solution {

    public int height(TreeNode root) {
        if (root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return 1 + Math.max(l, r);
    }

    public void helper(TreeNode root, int level, List<Integer> list) {
        if (root == null) return;

        if (level == 0) {
            list.add(root.val);
            return;
        }

        helper(root.left, level - 1, list);
        helper(root.right, level - 1, list);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        int h = height(root);
        List<Double> ans = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            List<Integer> list = new ArrayList<>();
            helper(root, i, list);

             long tot = 0;
            for (int val : list) {
                tot += val;
            }

            double avg = (double) tot / list.size();
            ans.add(avg);
        }

        return ans;
    }
}
