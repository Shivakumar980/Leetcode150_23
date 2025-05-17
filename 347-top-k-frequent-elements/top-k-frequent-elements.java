class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for( int num: nums){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq= new PriorityQueue<>((a,b)-> a.getValue()-b.getValue());

        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] res= new int[pq.size()];
        int index= pq.size()-1;
        while(!pq.isEmpty()){
            res[index--]=pq.poll().getKey();
        }

        return res;

    }
}