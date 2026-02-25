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
    int preIndex = 0;//keep trck of current element accessing
    HashMap<Integer,Integer>map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);//Store each value with its index in the map
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int start, int end) {

        if (start > end) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = map.get(rootVal);

        // left and right subtree
        root.left = build(preorder, start, inIndex - 1);
        root.right = build(preorder, inIndex + 1, end);

        return root;
    }

}