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
    public int minimumOperations(TreeNode root) {
        
        if(root==null ) return 0;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int totalOperations=0;
        while(!q.isEmpty()){

            int n=q.size();
            List<Integer> levelValues = new ArrayList<>();
           
            for(int i=0;i< n; i++){
                TreeNode node= q.poll();
                levelValues.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            totalOperations+= minimumSwaps(levelValues);
        }

        return totalOperations;
    }

    private int minimumSwaps(List<Integer> levelValues){
        int n=levelValues.size();
        int[] arr= new int[n];
        for(int i=0;i<n ;i++){
            arr[i]=levelValues.get(i);
        }

        int[][] arrayMap= new int[n][2];

        for(int i=0;i<n;i++){
            arrayMap[i][0]=arr[i];
            arrayMap[i][1]=i;
            
        }
        Arrays.sort( arrayMap,(a, b) -> Integer.compare(a[0], b[0]));

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for(int i=0 ; i<n ;i++){
            if(visited[i] || arrayMap[i][1]==i){
                continue;
            }
            int cyclesize=0;
            int j=i;
            while(!visited[j]){
                visited[j]=true;
                j=arrayMap[j][1];
                cyclesize++;
            }

            if(cyclesize>1){
                swaps+=(cyclesize-1);
            }



        }
        return swaps;
    }
}