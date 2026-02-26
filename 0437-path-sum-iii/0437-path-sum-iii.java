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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
           return count;
        helper(root, targetSum);
        return count;   
    }
    public void helper(TreeNode node,int targetSum){
        if(node == null)
           return;
        helper2(node,targetSum,0L);
        helper(node.left,targetSum);
        helper(node.right,targetSum);   
    }
    public void helper2(TreeNode node, int targetSum, Long current_sum){
        if(node == null)
           return;
        current_sum += node.val;
        if(current_sum == targetSum){
            count++;
        }  
        helper2(node.left,targetSum,current_sum);
        helper2(node.right,targetSum,current_sum); 
    }
}