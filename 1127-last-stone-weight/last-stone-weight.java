class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> b-a);

        for(int stone : stones){
            pq.offer(stone);
        }

       
        while(pq.size()!=1){
            int first= pq.poll();
            int second= pq.poll();
            if(first==second){
                pq.offer(0);
            }
            else{
                pq.offer(Math.abs(first-second));
            }
           
        }
        return pq.peek();

        
    }
}