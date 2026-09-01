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
    public List<Integer> largestValues(TreeNode root) {
        
        Queue<TreeNode> qu = new LinkedList<>();

        if(root==null){
            return new ArrayList<>();
        }

        qu.add(root);

        List<Integer> ans = new ArrayList<>();

        while(!qu.isEmpty()){

            int size = qu.size();

            int max = Integer.MIN_VALUE;

            for(int i = 0; i<size; i++){

                TreeNode node = qu.poll();

                max = Math.max(max, node.val);


                if(node.left!=null){
                    qu.add(node.left);
                }
                if(node.right!=null){
                    qu.add(node.right);
                }
            }

            ans.add(max);

            
        }
        return ans;
    }
}