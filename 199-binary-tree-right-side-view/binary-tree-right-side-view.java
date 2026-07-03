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

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }

        return 1+ Math.max(height(root.left) , height(root.right));
    }

    List<Integer> ans = new ArrayList<>();

    public void helper(TreeNode root,int h, int mHt){

        if(root==null){
            return;
        }

        if(mHt==ans.size()){
            return;
        }

        
        if(ans.size()<=h){
            ans.add(root.val);
        }

        

        helper(root.right , h+1 , mHt);
        helper(root.left,h+1 , mHt);
    }

    


    public List<Integer> rightSideView(TreeNode root) {
        
        int h = height(root);


        helper(root , 0 , h);

        return ans;


    }
}