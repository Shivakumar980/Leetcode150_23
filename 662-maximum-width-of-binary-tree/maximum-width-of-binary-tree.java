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
 class Pair{
    int hd;
    TreeNode node;
    public Pair(int hd, TreeNode node){
        this.hd=hd;
        this.node=node;
    }

 }
class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,root));
        int result=1;
        while(!q.isEmpty()){
            int n=q.size();
            int currsize=n;
            int count=0;
            int first=0;
            int last=0;
            while(currsize>0){
                count++;
                int hd=q.peek().hd;
                TreeNode node=q.peek().node;
                q.remove();
                if(count==1){
                    first=hd;
                }
                if(count==n){
                    last=hd;
                }
                
                if(node.left!=null){
                    q.add(new Pair(2*hd+1,node.left));
                }
                if(node.right!=null){
                    q.add(new Pair(2*hd+2,node.right));
                }
                currsize--;
            }
            result=Math.max(result,last-first+1);
        }
        return result;
    }
}