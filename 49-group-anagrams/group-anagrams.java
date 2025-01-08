class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> hm= new HashMap<>();
        
        for(String s: strs){
            char[] charArray= s.toCharArray();
            Arrays.sort(charArray);
            String sortedString =new String(charArray);
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