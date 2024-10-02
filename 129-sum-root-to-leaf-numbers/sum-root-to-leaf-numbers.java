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
   int totalsum=0;
    private int sumUtil(TreeNode root, int sum){
       if(root==null){
        return 0;
       }

        sum=(sum*10)+root.val;

        if(root.left==null && root.right==null ){
            return sum;
        }
        int leftsum=sumUtil(root.left,sum);
        int rightsum=sumUtil(root.right,sum);
         sum=sum/10;
        System.out.println(leftsum+" "+rightsum);
        return leftsum+rightsum;

    }
    public int sumNumbers(TreeNode root) {
        return sumUtil(root,0);   
        //sumNumbers(root.left,0)   
    }
}