class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> prev=new ArrayList<>();
        prev.add(1);
        for(int i=1;i<=rowIndex;i++){
            ArrayList<Integer> curr=new ArrayList<>();
            curr.add(1);
            for(int j=1;j<i;j++){
                curr.add(prev.get(j)+prev.get(j-1));
            }
            curr.add(1);
            prev=curr;
            //System.out.println(prev);
        }
        return prev;
    }
}