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

    boolean ans = true;

    public int isBalance(TreeNode root) {

        if(root==null){
            return 0;
        }

        int left = isBalance(root.left);
        int right = isBalance(root.right);

        int h = Math.max(left , right) +  1;

        if(Math.abs(left - right)>1){
            ans = false;
        }

        return h;
    
        
    }


    public boolean isBalanced(TreeNode root) {

        isBalance(root);

        return ans;
        
    
        
    }
}