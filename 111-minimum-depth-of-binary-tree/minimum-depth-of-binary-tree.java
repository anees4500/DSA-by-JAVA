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

    int minum = Integer.MAX_VALUE;


    public void helper(TreeNode root , int size ){

        if(root.left==null && root.right==null){
            minum = Math.min(size,minum);
            return ;
        }


        if(root.left!=null && root.right!=null){
            size++;
            helper(root.left,size);
            helper(root.right,size);
        }
        else if(root.left==null){
            size++;
            helper(root.right, size);
        }
        else{
            size++;
            helper(root.left,size);
        }

    }
    public int minDepth(TreeNode root) {

        if(root==null){
            return 0;
        }
        

        helper(root,1);

        return minum;
    }
}