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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
       if(root==null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> al=new ArrayList<>();
            while(n>0){
                TreeNode node=q.peek();
                int val=node.val;
                q.remove();
                al.add(val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                n--;
            }
            result.add(al);
        }
        return result;

    }
}