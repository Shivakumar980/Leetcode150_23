class Solution {
    public int minDistance(String word1, String word2) {
        
        int a= word1.length()- longestCommonSubsequence(word1, word2);
        int b = word2.length()-longestCommonSubsequence(word1, word2);
        return a+b;
    }

     public int longestCommonSubsequence(String text1, String text2) {

        int s1=text1.length();
        int s2=text2.length();

        int[][] dp=new int[s1+1][s2+1];

        for(int ind1=1;ind1<=s1;ind1++){
            for(int ind2=1; ind2<=s2 ;ind2++){
                if(text1.charAt(ind1-1)==text2.charAt(ind2-1)){
                    dp[ind1][ind2]=1+ dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2]= Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        }
      
        return dp[s1][s2];
    };
}