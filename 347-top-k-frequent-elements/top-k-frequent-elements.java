

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm= new HashMap<>();

        for(int num: nums){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue<>((a,b)->a.getValue()-b.getValue());

        for(Map.Entry<Integer,Integer> entry: hm.entrySet() ){
            if(pq.size()<k){
                pq.add(entry);
            }
            else if(entry.getValue()> pq.peek().getValue()){
                pq.poll();
                pq.add(entry);
            }
        }
        int[] ans= new int[k];
        while(!pq.isEmpty()){
            ans[--k]=pq.poll().getKey();
        }

        return ans;
    }
}