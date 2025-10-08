 
class Solution {
    static int index = 0;

    public void correct(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) return;

        correct(root.left, ans);
        root.val = ans.get(index++);   
        correct(root.right, ans);
    }

    public void inOrder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) return;

        inOrder(root.left, ans);
        ans.add(root.val);   
        inOrder(root.right, ans);
    }

    public void recoverTree(TreeNode root) {
        index = 0;   
        ArrayList<Integer> ans = new ArrayList<>();

         
        inOrder(root, ans);

         
        Collections.sort(ans);

        
        correct(root, ans);
    }
}
