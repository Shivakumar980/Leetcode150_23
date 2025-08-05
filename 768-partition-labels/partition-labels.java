class Solution {
    public List<Integer> partitionLabels(String s) {
        int n= s.length();
        List<Integer> result= new ArrayList<>();
        HashMap<Character, Integer> hm= new HashMap<>();
        for( int i=0; i< n; i++){
            hm.put(s.charAt(i),i);
        }

        int end=0;
        int size=0;
        for(int i=0; i< n ;i++){
            char ch= s.charAt(i);
            size+=1;
            end=Math.max(end, hm.get(ch));
            if(end==i){
                result.add(size);
                size=0;
            }
        }
        return result;
    }
}