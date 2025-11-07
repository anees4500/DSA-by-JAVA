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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> li = new ArrayList<>();
        levelOrder(root,li);
        return li;
    }

    public static void levelOrder(TreeNode root,List<Double> li){
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            int store = size;
            double sum = 0;
            while(size-->0){
                TreeNode presentNode = qu.remove();
                sum += presentNode.val;
                if(presentNode.left!=null){
                    qu.add(presentNode.left);
                }
                if(presentNode.right!=null){
                    qu.add(presentNode.right);
                }
            }
            li.add(sum/store);            
        }
    }
}