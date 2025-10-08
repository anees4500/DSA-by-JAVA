/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // public boolean isTrue(TreeNode root){

        // if(root==null){
        //     return true;
        // }

        // if(root.left==null && root.right==null){
        //     return true;
        // }
        // else if((root.left != null && root.val>root.left.val ) && (root.right != null && root.val<root.right.val)){
        //     return isTrue(root.left) && isTrue(root.right);
        // }
        // else if((root.left != null && root.val>root.left.val ) && root.right == null){
        //     return isTrue(root.left);
        // }
        // else if((root.right != null && root.val<root.right.val) && root.left == null){
        //     return isTrue(root.right);
        // }
        // else{
        //     return false;
        // }
    // }

    public  void helper(TreeNode root, ArrayList<Integer>  ans ){
        if(root==null){
            return ;
        }

        helper(root.left, ans);
        ans.add(root.val);
        helper(root.right, ans);

    }

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        helper(root,ans);

        for(int i = 1; i<ans.size(); i++){
            if(ans.get(i)<=ans.get(i-1)){
                return false;
            }
        }

        return true;


    }
}