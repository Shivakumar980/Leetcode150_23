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
    int sum=Integer.MIN_VALUE;
    //int maxsum=0;
    public int maxPathSum(TreeNode root) {
        height(root);
        return sum;
    }
    private int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftsum=Math.max(height(root.left),0);
        int rightsum=Math.max(height(root.right),0);

         sum=Math.max(sum,leftsum+rightsum+root.val);

        return Math.max(leftsum,rightsum)+root.val;
    }
}