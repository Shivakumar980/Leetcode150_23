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
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer,List<Integer>> al=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        rightSideViewUtil(root,al,0);
        System.out.println(al);
        al.forEach((key, value) -> {
            res.add(value.get(0));
            //System.out.println(res);
        });
        return res;
    }
    private void rightSideViewUtil(TreeNode root, HashMap<Integer,List<Integer>> map, Integer level){
            if(root!=null){
                if (!map.containsKey(level)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(root.val);
                    map.put(level,list);
                }else{
                    map.get(level).add(root.val);
                }
                
            rightSideViewUtil(root.right,map,level+1);
            rightSideViewUtil(root.left,map,level+1);
        }
    }
    
}