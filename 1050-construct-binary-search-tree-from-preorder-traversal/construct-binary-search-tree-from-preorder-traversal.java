class Solution {

    public TreeNode BuildBST(TreeNode root , int k){
        
        if(root==null){

          return new TreeNode(k);
            
        }
        else if(root.val>k){
            root.left = BuildBST(root.left,k); 
        }
        else if(root.val<k){
            root.right = BuildBST(root.right,k);
        }

        return root;

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;

        for(int i = 0; i<preorder.length; i++){

            int num = preorder[i];

            root = BuildBST(root, num);
        } 

        return root;
    }
}