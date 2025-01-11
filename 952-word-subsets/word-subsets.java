class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        HashMap<Character, Integer> bmap= new HashMap<>();
       
        for(String word: words2){
           HashMap<Character, Integer> fmap = new HashMap<>();
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    fmap.put(c, fmap.getOrDefault(c, 0) + 1); // Increment frequency in fmap
                }
                for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {
                    char c = entry.getKey();
                    int freq = entry.getValue();
                    bmap.put(c, Math.max(bmap.getOrDefault(c, 0), freq)); // Update bmap with max frequency
                }
        }

       List<String> ans= new ArrayList<>();
        for(String word: words1){
            HashMap<Character, Integer> amap= new HashMap<>();
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                amap.put(c, amap.getOrDefault(c,0)+1);
            }
             boolean flag= true;
            for(Map.Entry<Character,Integer> entry: bmap.entrySet()){
               
                if(amap.get(entry.getKey())==null || amap.get(entry.getKey())<entry.getValue()){
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans.add(word);
            }
        }
        return ans;
    }
}