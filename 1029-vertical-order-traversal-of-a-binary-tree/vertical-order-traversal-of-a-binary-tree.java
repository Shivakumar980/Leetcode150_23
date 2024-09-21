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
    int depth;
    TreeNode node;
    public Pair(int hd,int depth,TreeNode node){
        this.hd=hd;
        this.depth=depth;
        this.node=node;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        TreeMap<Integer, List<Integer>> ihm=new TreeMap<>();
        TreeMap<Integer, TreeMap<Integer, List<Integer> >> hm=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,root));
        while(!q.isEmpty()){
            int hd=q.peek().hd;
            int depth=q.peek().depth;
            int val=q.peek().node.val;
            TreeNode node=q.peek().node;
            q.remove();
            ////ihm.putIfAbsent(depth,new ArrayList<>());
            //ihm.get(depth).add(val);

            hm.putIfAbsent(hd,new TreeMap<Integer, List<Integer>>());
            hm.get(hd).putIfAbsent(depth,new ArrayList<Integer>());
            hm.get(hd).get(depth).add(val);

            if(node.left!=null){
                q.add(new Pair(hd-1,depth+1,node.left));
            }
            if(node.right!=null){
                q.add(new Pair(hd+1,depth+1,node.right));
            }

        }
        System.out.println(hm);
        for(Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry:hm.entrySet()){
                List<Integer> innerAl= new ArrayList<>();
            for(Map.Entry<Integer,List<Integer>> innerEntry:entry.getValue().entrySet()){
                 List<Integer> arrayList= innerEntry.getValue();
                Collections.sort(arrayList);
                innerAl.addAll(arrayList);

            }
            res.add(innerAl);

            //List<Integer> arrayList = new ArrayList<>(entry.getValue());
           
        }
        return res;
    }
}