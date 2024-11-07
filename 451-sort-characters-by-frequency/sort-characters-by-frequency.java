class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm=new HashMap<>();
        int n=s.length();
        for(char c: s.toCharArray()){
           hm.put(c,hm.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(hm.entrySet());

        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry=pq.poll();
            char c=entry.getKey();
            int frequency=entry.getValue();
            for(int i=0;i<frequency;i++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}