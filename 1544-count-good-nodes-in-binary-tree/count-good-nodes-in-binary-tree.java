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
    int cnt=0;
    private void helper(TreeNode root, int maxval){
        if(root==null){
            return;
        }
        if(root.val>=maxval){
            cnt++;
        }
        maxval=Math.max(root.val,maxval);
        helper(root.left,maxval);
        helper(root.right,maxval);
        return;
    }
    public int goodNodes(TreeNode root) {
        helper(root,root.val);
        return cnt;
    }
}