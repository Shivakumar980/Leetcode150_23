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
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer,List<Integer>> al=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        rightSideViewUtil(root,res,0);
        //System.out.println(al);
        return res;
    }
    private void rightSideViewUtil(TreeNode root, List<Integer> al, Integer level){
            if(root==null){
                return;
                }
                if(al.size()==level){
                    al.add(root.val);
                }
            rightSideViewUtil(root.right,al,level+1);
            rightSideViewUtil(root.left,al,level+1);
        }
    
    
}