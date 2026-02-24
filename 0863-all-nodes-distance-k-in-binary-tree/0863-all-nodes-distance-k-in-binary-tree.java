/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode>map = new HashMap<>();//child and parent
        // map.put(root,null);//root ka parent null
        buildParentMap(root,null,map);  
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(target);//q me target add
        Set<TreeNode>visited = new HashSet<>();
        visited.add(target);
        int distance = 0;
        //level order
        while(!q.isEmpty()){
            int size = q.size();
            if(distance == k)
               break;

            for(int i = 0; i < size;i++){
                TreeNode curr = q.poll();//target remove
                if(curr.left!= null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                 if(curr.right!= null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                TreeNode parent = map.get(curr);

                if(parent != null && !visited.contains(parent)){
                    visited.add(parent);
                    q.offer(parent);

                }
            }
            distance++;
        }
        List<Integer>ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);

        }
        return ans;

    }
    public void buildParentMap(TreeNode node,TreeNode parent, HashMap<TreeNode,TreeNode>map){
        if(node == null){
            return;

           
        }
         map.put(node,parent);
            buildParentMap(node.left,node,map);//har ek node ko parent ke sath attach
            buildParentMap(node.right,node,map);//node ko call parent ke sath
    }
}