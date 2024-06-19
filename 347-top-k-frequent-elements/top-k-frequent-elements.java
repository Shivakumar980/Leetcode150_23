class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
 
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            pq.add(entry);
        }
        int[] res=new int[k];
        int index=0;
        while(k>0){
            res[index++]=pq.poll().getKey();
            k--;
        }
        return res;
    }
}