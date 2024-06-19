class Solution {
    public int findKthLargest(int[] nums, int k) {
        int m=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            pq.add(num);
        }
        while(k>0){
             m=pq.poll();
            //System.out.println(m);
            k--;
        }
        return m;
        
    }
}