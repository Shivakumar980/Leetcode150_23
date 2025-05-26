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
    public boolean isBalanced(TreeNode root) {
        boolean[] res= new boolean[1];
        res[0]=true;
        calculateHeight(root,res);
        return res[0];
    }

     private int calculateHeight(TreeNode root, boolean[] res){

        if(root==null) return 0;
        int ld= calculateHeight(root.left,res);
        int rd= calculateHeight(root.right,res);

        if(Math.abs(ld-rd)>1){
            res[0]=false;
        }

        return 1+ Math.max(ld, rd);

    }
}