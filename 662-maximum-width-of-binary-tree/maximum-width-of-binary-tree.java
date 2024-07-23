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
    TreeNode node;
    int ind;
    public Pair(TreeNode node,int ind){
        this.node=node;
        this.ind=ind;
    }
}
class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int max=0;
        while(!q.isEmpty()){
            int sz=q.size();
            int count=0;
            int min=q.peek().ind;
            int first=0,last=0;
            int currsize=sz;
            while(currsize>0){
                count++;
                int ind=q.peek().ind-min;
                TreeNode node=q.peek().node;
                q.remove();
                if(count==1){
                     first=ind;
                }
                if(count==sz){
                     last=ind;
                   //  System.out.println(last);
                }
                 
                if(node.left!=null){
                    q.add(new Pair(node.left,2*ind+1));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right,2*ind+2));
                }
                
                currsize--;
            }
            max=Math.max(max,last-first+1);
            //System.out.println(max+"first"+first+"last"+last);
        }
        return max;
    }
}