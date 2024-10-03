/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q || root==null) return root;

        TreeNode leftNode=lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode=lowestCommonAncestor(root.right,p,q);

        if(leftNode==null && rightNode==null){
            return null;
        }
        else if(leftNode!=null && rightNode==null){
            return leftNode;
        }
        else if(leftNode==null && rightNode!=null){
            return rightNode;
        }
        else{
            return root;
        }
    }
}