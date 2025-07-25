class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result= new ArrayList<>();
        HashMap<String,List<String>> hm= new HashMap<>();

        int n=strs.length;
        for(int i=0; i< n ;i++){
                char[] charArray= strs[i].toCharArray();
                Arrays.sort(charArray);
                String key= new String(charArray);
                if(!hm.containsKey(key)){
                    hm.put(key, new ArrayList<>());
                }
                hm.get(key).add(strs[i]);
        }

        for(Map.Entry<String,List<String>> entry: hm.entrySet()){
            result.add(entry.getValue());
        }
        return result;

    }
}