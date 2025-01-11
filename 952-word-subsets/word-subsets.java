class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] bmap=new int[26];
        for(String word: words2){
            int[] fmap= new int[26];
            for(int i=0;i<word.length(); i++){
                char c= word.charAt(i);
                fmap[c-'a']++;
                bmap[c-'a']= Math.max(bmap[c-'a'], fmap[c-'a']);
            }
        }
        List<String> ans= new ArrayList<>();
        for(String word: words1){
            int[] amap= new int[26];
            for(int i=0;i<word.length(); i++){
                char c= word.charAt(i);
                amap[c-'a']++;
            }
            boolean flag=true;
            for(int i=0;i<26;i++){
                if(amap[i]<bmap[i]){
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