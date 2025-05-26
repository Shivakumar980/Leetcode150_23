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
    public int diameterOfBinaryTree(TreeNode root) {

        int[] res= new int[1];

        calculateHeight(root, res);

        return res[0];
        }

    private int calculateHeight(TreeNode root, int[] res){

        if(root==null) return 0;
        int ld= calculateHeight(root.left,res);
        int rd= calculateHeight(root.right,res);

        res[0]=Math.max(res[0], ld+rd);

        return 1+ Math.max(ld, rd);

    }
}