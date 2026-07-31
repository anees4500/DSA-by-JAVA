class Solution {

    public class Pair {

        TreeNode node;
        int num;

        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;

        Queue<Pair> qu = new LinkedList<>();

        qu.offer(new Pair(root, 0));

        int ans = 0;

        while(!qu.isEmpty()) {

            int size = qu.size();

            int minIndex = qu.peek().num;

            int first = 0;
            int last = 0;

            for(int i = 0; i < size; i++) {

                Pair pair = qu.poll();

                int curr_id = pair.num - minIndex;

                TreeNode node = pair.node;

                if(i == 0) {
                    first = curr_id;
                }

                if(i == size - 1) {
                    last = curr_id;
                }

                if(node.left != null) {
                    qu.offer(new Pair(node.left, 2 * curr_id + 1));
                }

                if(node.right != null) {
                    qu.offer(new Pair(node.right, 2 * curr_id + 2));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}