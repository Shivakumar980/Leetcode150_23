class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> hm= new HashMap<>();
        
      
        for(String s: strs){
            int[] cmap= new int[26];
            for(char c:s.toCharArray()){
                cmap[c-'a']++; 
            }
            String sortedString =Arrays.toString(cmap);
            hm.putIfAbsent(sortedString, new ArrayList<String>());
        
         
            hm.get(sortedString).add(s);
             

         }
        List<List<String>>  ans= new ArrayList<>();

        for(List<String> listOfStrings:hm.values()){
            ans.add(listOfStrings);
        }
    return ans;

    }
}