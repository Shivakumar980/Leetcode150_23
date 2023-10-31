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
    List<Double> sol=new ArrayList();
    public List<Double> averageOfLevels(TreeNode root) {
        helper(root);
        return sol;
    }
    private void helper(TreeNode root){
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            double sum=0;
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                 if(node.left!=null){
                queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                sum+=node.val;
            }
            sol.add(sum/size);
           

        }
    }
}