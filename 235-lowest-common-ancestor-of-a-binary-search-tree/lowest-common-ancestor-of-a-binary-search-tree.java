import java.util.*;

class Solution {

    public boolean parents(TreeNode root, TreeNode target, List<TreeNode> list){

        if(root == null){
            return false;
        }

        // add current node in path
        list.add(root);

        // target mil gaya
        if(root == target){
            return true;
        }

        // BST search logic
        if(target.val < root.val){
            if(parents(root.left, target, list)) return true;
        } else {
            if(parents(root.right, target, list)) return true;
        }

        // backtrack (agar path galat hai)
        list.remove(list.size() - 1);
        return false;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> lp = new ArrayList<>();
        List<TreeNode> lq = new ArrayList<>();

        // get paths
        parents(root, p, lp);
        parents(root, q, lq);

        // compare paths
        int i = 0;
        TreeNode ans = null;

        while(i < lp.size() && i < lq.size()){
            if(lp.get(i) == lq.get(i)){
                ans = lp.get(i);
            } else {
                break;
            }
            i++;
        }

        return ans;
    }
}