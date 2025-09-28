class Pair{
    int remaining_count;
    int time;

    public Pair(int count, int time){
        this.remaining_count=count;
        this.time=time;
    }
}
    
class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] frequencyMap = new int[26];

        for(char task: tasks){
            frequencyMap[task-'A']++;
        }

        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> b-a);

        for(int val: frequencyMap){
            if(val>0){
                pq.add(val);
            }
        }

        Queue<Pair> cooldown= new LinkedList<>();

        int time=0;
        while(!pq.isEmpty() || !cooldown.isEmpty()){
           

            if(!pq.isEmpty()){
                int count= pq.poll();
                count-=1;
                if(count>0){
                    cooldown.offer(new Pair(count,time+n));
                }
            }
            if(!cooldown.isEmpty() && cooldown.peek().time==time){
                pq.offer(cooldown.poll().remaining_count);
            }
            time+=1;
        }
        return time;

    }
}