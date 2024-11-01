class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<Integer> innerList=new ArrayList<>();
        innerList.add(1);
        List<List<Integer>> outerList=new ArrayList<>();
        outerList.add(innerList);
       for(int i=1;i<numRows;i++){
            List<Integer> currList=new ArrayList<>();
            List<Integer> prevList=outerList.get(i-1);
            currList.add(1);
            for(int j=1;j<i;j++){
                currList.add(prevList.get(j-1)+prevList.get(j));
            }
            currList.add(1);
            outerList.add(currList);
        }
        return outerList;
    }
}