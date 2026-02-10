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

        int lh = height(root.left);
        int rh = height(root.right);
        return 1+ Math.max(lh,rh);
    }

    public void Nth(TreeNode root, int n, List<Integer> list, int i){

        if(root==null){
            return ;
        }

        if(i==n){
            list.add(root.val);
            return;
        }
        i++;
        Nth(root.left,n,list,i);
        Nth(root.right,n,list,i);

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        int ht = height(root);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = ht; i>0; i--){
            List<Integer> list = new ArrayList<>();
            Nth(root,i,list,1);
            ans.add(new ArrayList<>(list));
        }

        return ans;
    }
}