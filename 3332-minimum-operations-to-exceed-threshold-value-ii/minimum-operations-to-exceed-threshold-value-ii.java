class Solution {
    public int minOperations(int[] nums, int k) {
        
        PriorityQueue<Long> pq= new PriorityQueue<>();

        int n = nums.length;

        for( int i=0 ; i< n ;i++){
            pq.add((long)nums[i]);
        }
        int count=0;
        while(pq.peek()<k && pq.size()>=2){
            long x= pq.poll();
            long y=pq.poll();

            long num= 2*Math.min(x,y) + Math.max(x,y);
            pq.add(num);
            count++;
        }

        return count;
    }
}