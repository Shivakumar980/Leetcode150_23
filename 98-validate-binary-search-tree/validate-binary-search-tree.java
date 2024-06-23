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
    private void isValidBSTUtil(TreeNode root,List<Integer> al){
        if(root!=null){
            isValidBSTUtil(root.left,al);
            al.add(root.val);
            isValidBSTUtil(root.right,al);
        }
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> al=new ArrayList<>();
        isValidBSTUtil(root,al);
        for(int i=1;i<al.size();i++){
            if(al.get(i-1)<al.get(i)){
                continue;
            }
            else
                return false;
        }
        return true;
    }
}