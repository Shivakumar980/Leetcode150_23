class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n= nums.length;
        HashMap<Integer, Integer> hm= new HashMap<>();

        for(int num:nums){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }
        ArrayList<Integer>[] bucket= new ArrayList[nums.length+1];

        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            if(bucket[entry.getValue()]==null){
                bucket[entry.getValue()]=new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] ans= new int[k];
        for(int i=n; i>=0; i--){
            if(bucket[i]!=null){
                for(int element: bucket[i]){
                    ans[--k]=element;
                }
                if(k==0) return ans;
            }
        }
        return ans;
    }
}

