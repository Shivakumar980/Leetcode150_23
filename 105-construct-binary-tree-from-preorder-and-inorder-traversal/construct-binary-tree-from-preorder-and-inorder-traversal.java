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
    int[] preorderCopy;
    int preOrderStart=0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderCopy= preorder;
        Map<Integer, Integer> mpp= new HashMap<>();
        for(int i=0; i< inorder.length; i++){
            mpp.put(inorder[i],i);
        }

        return constructTree( 0,  inorder.length-1,  mpp);
    }

    private TreeNode constructTree(int start, int end, Map<Integer,Integer> mpp){
        if(start>end) return null;

        int rootVal= preorderCopy[preOrderStart++];
        TreeNode root= new TreeNode(rootVal);

        int inOrderIndex= mpp.get(rootVal);

        root.left= constructTree( start, inOrderIndex-1 ,mpp);
        root.right= constructTree( inOrderIndex+1, end, mpp);

        return root;
    
    }
}