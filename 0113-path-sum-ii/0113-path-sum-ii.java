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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
        helper(root, targetSum, path, result);
        return result;
    }
    public void helper(TreeNode node, int targetSum, List<Integer>path, List<List<Integer>>result){
        if(node == null)
           return;
        path.add(node.val);
        targetSum -= node.val;
        if(node.left == null && node.right == null&&targetSum == 0){
            result.add(new ArrayList<>(path));
        }
        helper(node.left,targetSum,path,result);
        helper(node.right,targetSum,path,result);

        path.remove(path.size()-1);   //backtrack
    }
}