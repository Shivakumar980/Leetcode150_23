class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> count= new HashMap<>();

        for(int num: nums){
            count.put(num, count.getOrDefault(num,0)+1);
        }

        ArrayList<Integer>[] bucket= new ArrayList[nums.length+1];

        for(int key: count.keySet()){
            int val=count.get(key);
            if(bucket[val]==null){
                bucket[val]=new ArrayList<>();
            }
            bucket[val].add(key);
        }

        int[] ans= new int[k];
        for(int i=nums.length ; i>0 ;i--){
            if(bucket[i]!=null){
                for(int element: bucket[i]){
                    ans[--k]=element;
                    if(k==0) return ans;
                }
            }
        }
        return ans;
        
    }
}