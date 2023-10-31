
class Solution {
    List <Integer> lis=new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root); 
        return lis;  
    }
    private void helper(TreeNode root){
        if(root==null){
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size=queue.size();
                for(int i=0;i<size;i++){
                    TreeNode node=queue.poll();
                    if(i==size-1){
                        lis.add(node.val);
                    }
                    if(node.left!=null) queue.offer(node.left);
                    if(node.right!=null) queue.offer(node.right);
                }

            }
           return; 
         }

    }
   
