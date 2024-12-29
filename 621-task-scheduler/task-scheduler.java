//ab_ab_ab
//ababcd
//ab__ab__ab
class Pair {
        int value;
        int tm;

        Pair(int value, int tm) {
            this.value = value;
            this.tm = tm;
        }
    }
class Solution {
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int[] freq=new int[26];
        for(int task : tasks){
            freq[task-'A']++;
        }

        for(int val: freq){
            if(val>0){
                pq.add(val);
            }
        }
        Queue<Pair> q=new LinkedList<>();

        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                  int smallest=pq.poll();
                  smallest--;
                  if(smallest>0){
                    q.add(new Pair(smallest, time+n));
                  }
            }
     
            if(!q.isEmpty() && q.peek().tm==time){
                int fval=q.poll().value;
                pq.add(fval);
            }

        }
        return time;
    }
}
