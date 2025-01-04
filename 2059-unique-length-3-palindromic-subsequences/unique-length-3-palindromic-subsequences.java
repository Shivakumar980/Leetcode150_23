class Solution {
    public int countPalindromicSubsequence(String s) {

        HashSet<String> hs=new HashSet<>();
        for(char ch='a'; ch<='z'; ch++){

            int startIndex = s.indexOf(ch);
            int endIndex   = s.lastIndexOf(ch);


            if(startIndex!=-1 && endIndex!=-1){
                for(int i= startIndex+1 ;i < endIndex; i++){
                String ss = "" + s.charAt(startIndex) + s.charAt(i) + s.charAt(endIndex);
                hs.add(ss);
                 }

            }
            


        }

        return hs.size();
        
    }
}