class Pair{
    int value;
    int time;
    public Pair(int value, int time){
        this.value=value;
        this.time=time;
    }
}
    
class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] fmap= new int[26];

        for(char task: tasks){
            fmap[task-'A']++;
        }



        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int val: fmap){
            if(val>0) {
                pq.offer(val);
            };
        }

        Queue<Pair> q= new LinkedList<>();
        int tm=0;
        while(!pq.isEmpty() || !q.isEmpty()){

            if(!pq.isEmpty()){
                int val= pq.poll();
                val-=1;
                if(val>0){
                    q.add(new Pair(val,tm+n));
                }
            } 

            if(!q.isEmpty() &&q.peek().time==tm){
                Pair p= q.poll();
                pq.add(p.value);
            }
              
            tm++;

        }

        return tm;
        
    }
}