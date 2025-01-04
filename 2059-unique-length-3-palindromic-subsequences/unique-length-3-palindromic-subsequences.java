class Solution {
    public int countPalindromicSubsequence(String s) {

        
        int ans=0;
        for(char ch='a'; ch<='z'; ch++){

            int startIndex = s.indexOf(ch);
            int endIndex   = s.lastIndexOf(ch);

            Set<Character> hs=new HashSet<>();
            if(startIndex!=-1 && endIndex!=-1){
                for(int i= startIndex+1 ;i < endIndex; i++){
               
                hs.add(s.charAt(i));
                 }
                

            }
            ans+=hs.size();
            


        }

        return ans;
        
    }
}