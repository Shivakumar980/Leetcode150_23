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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0) return null;
        return constructBST(preorder,0,preorder.length-1);    
    }
    private TreeNode constructBST(int[] preorder,int start,int end){
        if(start>end){
            return null;
        }
        int rootVal=preorder[start];
        TreeNode node=new TreeNode(rootVal);
        int count=0;
        int left=start+1;
        int right=end;
        while(left<=right){
            if(preorder[left]<rootVal){
                left++;
            }
            else{
                break;
            }
        }
         node.left=constructBST(preorder,start+1,left-1);
         node.right=constructBST(preorder,left,end);
        return node;
 
    }
}