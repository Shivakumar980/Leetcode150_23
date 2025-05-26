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
    int count=0;
    public int goodNodes(TreeNode root) {
        return countNodes( root, root.val);
    }
    private int countNodes(TreeNode node , int maximum){
        if(node==null) return 0;

        int count = (node.val>= maximum) ? 1:0;
        maximum= Math.max(maximum,node.val);
        count+= countNodes(node.left,maximum);
        count+= countNodes(node.right,maximum);

        return count;
    }


}