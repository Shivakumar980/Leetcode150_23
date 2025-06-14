class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n= s.length();
        int[] dp= new int[n];

        Arrays.fill(dp,-1);
        return dfs(n-1,s, wordDict, dp);
        
    }

    private boolean dfs(int ind, String s, List<String> wordDict, int[] dp){
        if(ind<0){
            return true;
        }
        if(dp[ind]!=-1){
            return dp[ind]==1;
        }

        for(String word: wordDict){
            if (ind-word.length()+1 <0){
                continue;
            }
            if(s.substring(ind-word.length()+1, ind+1).equals(word) && dfs(ind-word.length(),s,wordDict,dp)){
                dp[ind]=1;
                return true;
            }
        }
        dp[ind]=0;
        return false;
    }
}