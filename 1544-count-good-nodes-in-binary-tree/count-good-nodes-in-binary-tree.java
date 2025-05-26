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
    
    public int goodNodes(TreeNode root) {
        return countNodes( root, root.val, new int[]{0});
    }
    private int countNodes(TreeNode node , int maximum, int[] count){
        if(node==null) return 0;
        if(node.val>= maximum){
            count[0]+=1;
            maximum=node.val;
        }
        int left= countNodes(node.left,maximum,count);
        int right= countNodes(node.right,maximum,count);

        return count[0];
    }


}