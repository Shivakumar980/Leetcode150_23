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
    List<List<Integer>> lis=new ArrayList();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return lis;
        }
        helper(root);
        return lis;
    }
    private void helper(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> templist=new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode node=q.poll();
                    templist.add(node.val);
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);

            }
            if(flag){
                lis.add(templist);
            } 
            else{ 
                List<Integer> revArrayList=new ArrayList<>();
                for (int i = templist.size() - 1; i >= 0; i--) {         
                revArrayList.add(templist.get(i));}
                lis.add(revArrayList);
        }
        flag=!flag;
            }
            }
        }
    



