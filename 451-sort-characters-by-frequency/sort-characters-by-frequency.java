class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm= new HashMap<Character, Integer>();

        int n= s.length();

        for(int i=0; i< n ;i++){
            char c= s.charAt(i);
            hm.put(c, hm.getOrDefault(c,0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq= new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        for(Map.Entry<Character, Integer> entry:hm.entrySet()){
            pq.add(entry);
        }

        StringBuilder sb= new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry= pq.poll();
            int count= entry.getValue();
            while(count>0){
                sb.append(entry.getKey());
                count--;
            }
        }

        return sb.toString();
    }
}