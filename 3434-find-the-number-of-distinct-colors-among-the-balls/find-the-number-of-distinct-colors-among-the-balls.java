class Solution {
    public int[] queryResults(int limit, int[][] queries) {
            
            int n=queries.length;
            int[] ans= new int[n];
            int index=0;
            HashMap<Integer,Integer> hm= new HashMap<>();
            HashMap<Integer,Integer> valueFrequency= new HashMap<>();
            for(int i=0;i<n ;i++){
                int ball=queries[i][0];
                int color= queries[i][1];

                if(hm.containsKey(ball)){
                    int val= hm.get(ball);
                    valueFrequency.put(val,valueFrequency.get(val)-1);
                    if(valueFrequency.get(val)==0){
                        valueFrequency.remove(val);
                    }
                }
                hm.put(ball,color);
                valueFrequency.put(color,valueFrequency.getOrDefault(color,0)+1 );
        
                ans[i]=valueFrequency.size();
            }
        return ans;
    }
}