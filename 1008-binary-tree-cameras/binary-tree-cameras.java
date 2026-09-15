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

    static int camera = 0;

    public int dfs(TreeNode root){
        
        if(root==null){
            return 1;
        }

        int LC = dfs(root.left);
        int RC = dfs(root.right);

        if(LC==-1 || RC==-1){
            camera++;
            return 0;
        }

        if(LC==0 || RC == 0){
            return 1;
        }

        return -1;



    }
    public int minCameraCover(TreeNode root) {

        camera = 0;

        int req = dfs(root);

        if(req==-1)camera++;

        return camera;
        
    }
}