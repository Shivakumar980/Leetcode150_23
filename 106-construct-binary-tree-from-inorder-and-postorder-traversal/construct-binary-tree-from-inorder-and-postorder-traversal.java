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
    int[] postorderCopy;
    int postorderIndex; 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex= postorder.length-1;
        postorderCopy=postorder;
        HashMap<Integer, Integer> hm= new HashMap<>();
        for(int i=0; i< inorder.length ;i++){
            hm.put(inorder[i],i);
        }

        return constructTree(0, inorder.length-1 , hm);
    }
    private TreeNode constructTree(int start,int  end,HashMap<Integer, Integer> hm){
        if(start>end) return null;

        int rootVal= postorderCopy[postorderIndex--];

        TreeNode root= new TreeNode(rootVal);
        int inorderIndex= hm.get(rootVal);
        
        root.right= constructTree(inorderIndex+1, end , hm);

        root.left= constructTree(start, inorderIndex-1, hm);
       
        return root;
    }
}