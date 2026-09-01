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

    int ans = Integer.MIN_VALUE;
    int h = 0;
    public void preOrd(TreeNode root,  int ht){
        
        // base 
        if(root==null){
            return ;
        }

        ht++;
        if(h<ht){
            ans = root.val;
            h = ht;
        }
        preOrd(root.left , ht);
        

        
        preOrd(root.right, ht );
        ht--;
         
    }
    public int findBottomLeftValue(TreeNode root) {

        
        preOrd(root, 0);

        return ans;
        
    }
}