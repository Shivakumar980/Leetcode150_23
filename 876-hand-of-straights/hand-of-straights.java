class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0){
            return false;
        }

        HashMap<Integer, Integer> countMap= new HashMap<>();
        for(int num:hand){
            countMap.put(num, countMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq= new PriorityQueue(countMap.keySet());
        while(!pq.isEmpty()){
            int key= pq.peek();
            for(int i=key ; i<groupSize+key ; i++){
                if(!countMap.containsKey(i)){
                    return false;
                }
                countMap.put(i, countMap.get(i)-1);
                if(countMap.get(i)==0){
                    if(pq.peek()!=i){
                        return false;
                    }
                    pq.poll();
                }

            }

        }
        return true;
    }
}