 class Solution {
    public int Height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = Height(root.left);
        int rh = Height(root.right);
        return 1 + Math.max(lh, rh);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){   // ✅ handle empty tree
            return true;
        }
        int ls = Height(root.left);
        int rs = Height(root.right);

        if(Math.abs(ls - rs) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
