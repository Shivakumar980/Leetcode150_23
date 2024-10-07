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
    private void inorder(TreeNode root,int k,int[] count){
            if(root==null){
                return;
            }
            inorder(root.left,k,count);
            count[0]+=1;
            if(count[0]==k){
                 count[1]=root.val;
            }
            inorder(root.right,k,count);
        }
    public int kthSmallest(TreeNode root, int k) {
        int[] count=new int[]{0,-1};
         inorder(root,k,count);
         return count[1];
    }
}