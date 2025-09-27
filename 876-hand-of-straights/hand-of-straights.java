class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        Map<Integer, Integer> map= new TreeMap<>();

        for(int card: hand){
            map.put(card, map.getOrDefault(card, 0)+1);
        }

        for(int key: map.keySet()){
            while(map.get(key)>0){
                for(int i=0; i< groupSize; i++){
                    if(map.getOrDefault(key+i,0)==0){
                        return false;
                    }
                    else{
                        map.put(key+i, map.get(key+i)-1);
                    }
                }
            }
        }
        return true;
    }
}