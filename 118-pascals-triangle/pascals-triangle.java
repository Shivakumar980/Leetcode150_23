class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> row=new ArrayList<>();
        row.add(1);
        ans.add(row);
        for(int i=1;i<numRows;i++){
             List<Integer> curr=new ArrayList<>();
             List<Integer> prev=ans.get(i-1);
             curr.add(1);
             for(int j=1;j<i;j++){
                curr.add(prev.get(j)+prev.get(j-1));
             }
             curr.add(1);
             ans.add(curr);
        }
        return ans;
    }
}