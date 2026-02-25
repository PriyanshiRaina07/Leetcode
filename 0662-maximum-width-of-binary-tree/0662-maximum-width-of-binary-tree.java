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
    static class pair {
        TreeNode node;
        int index;
        public pair(TreeNode node ,int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Deque<pair>q = new ArrayDeque<>();
        q.offer(new pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int firstIndex = q.peekFirst().index;
            int lastIndex = q.peekLast().index;
            maxWidth = Math.max(maxWidth,lastIndex-firstIndex+1);
            for(int i = 0; i < size; i++){
                pair curr = q.poll();
                TreeNode node = curr.node;
                int idx = curr.index;
                if(node.left != null){
                    q.offer(new pair(node.left,2*idx+1));
                }
                if(node.right != null){
                    q.offer(new pair(node.right,2*idx+2));
                }
            }
        }
        return maxWidth;
    }
}