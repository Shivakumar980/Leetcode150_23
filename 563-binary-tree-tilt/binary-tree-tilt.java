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
    public int findTilthelper(TreeNode root){
        if(root==null) return 0;
        int sumleft=findTilthelper(root.left);
        int sumright=findTilthelper(root.right);
        sum+=Math.abs(sumleft-sumright);
        return sumleft+sumright+root.val;

    }
    int sum=0;
    public int findTilt(TreeNode root) {
        findTilthelper(root);
        return sum;
    }
}