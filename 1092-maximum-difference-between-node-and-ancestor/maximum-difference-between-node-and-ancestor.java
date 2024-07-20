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
    int max=0;
    private void helper(TreeNode root,int minval,int maxval){
        if(root==null){
            return;
        }
        minval=Math.min(root.val,minval);
        maxval=Math.max(root.val,maxval);
        helper(root.left,minval,maxval);
        helper(root.right,minval,maxval);
        max=Math.max(max,Math.abs(minval-maxval));
        return;
    }
    public int maxAncestorDiff(TreeNode root) {
        helper(root,root.val,root.val);
        return max;
    }
}