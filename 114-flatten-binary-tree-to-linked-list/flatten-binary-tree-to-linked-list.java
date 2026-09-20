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
    public TreeNode help(TreeNode root){
        if(root==null){
            return null;
        }

        TreeNode left = help(root.left);
        
        TreeNode right = help(root.right);

        root.left = null;
        root.right = left;
        TreeNode temp = root ;

        while(temp.right!=null){
            temp = temp.right;
            
        }
        
        temp.right = right;
 
        return root;
        
    }
    public void flatten(TreeNode root) {

        help(root);

        
        
    }
}