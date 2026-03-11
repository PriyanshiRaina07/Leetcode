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
    static int cam;
    public int minCameraCover(TreeNode root) {
        cam = 0;
        if(helper(root) == 0) cam++;

        return cam;
    
    }
    int helper(TreeNode root){
        if(root == null) return 2;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == 0||right == 0){
            cam++;
            return 1;
        }
        if(left == 1 || right == 1){
            return 2;
        }
        return 0;
     
    }
}