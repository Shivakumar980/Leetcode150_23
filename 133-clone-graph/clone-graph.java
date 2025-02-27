/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer,Node> hm=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Node ans=new Node();
        ans.val=node.val;
        hm.put(node.val,ans);
        for(int i=0;i<node.neighbors.size();i++){
            if(!hm.containsKey(node.neighbors.get(i).val)){
                cloneGraph(node.neighbors.get(i));
            }
        }
        for(int i=0;i<node.neighbors.size();i++){
            ans.neighbors.add(hm.get(node.neighbors.get(i).val));
        }
        return ans;
    }
}