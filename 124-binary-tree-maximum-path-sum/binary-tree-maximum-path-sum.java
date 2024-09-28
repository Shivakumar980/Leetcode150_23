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

    private int pathsum(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftsum=Math.max(0,pathsum(root.left));
        int rightsum=Math.max(0,pathsum(root.right));
        sum=Math.max(sum,leftsum+rightsum+root.val);
       
        return Math.max(leftsum,rightsum)+root.val;
    }
    int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        pathsum(root);
        return sum; 
    }
}