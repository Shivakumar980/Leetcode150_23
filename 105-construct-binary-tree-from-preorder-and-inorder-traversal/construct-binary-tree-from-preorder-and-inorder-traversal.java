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
    int preorderStart=0;
    int[] preorder1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorder1=preorder;
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return constructTree(0,inorder.length-1,hm);
    }
    private TreeNode constructTree(int start, int end,HashMap<Integer, Integer> hm ){
        if(start>end){
            return null;
        }
        int rootVal=preorder1[preorderStart++];
        TreeNode root= new TreeNode(rootVal);
        int indexInorder=hm.get(rootVal);
        root.left=constructTree(start,indexInorder-1,hm);
        root.right=constructTree(indexInorder+1,end,hm);
        return root;
    }
}