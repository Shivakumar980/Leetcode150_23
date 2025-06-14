class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();

        int[][] dp= new int[n1][n2];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

        return dfs(n1-1, n2-1, text1, text2, dp);
        
    }
    private int dfs(int ind1, int ind2, String s1, String s2, int[][] dp){
        if(ind1<0 || ind2<0) return 0;
        if(ind1==0 && ind2==0){
            return s1.charAt(ind1)==s2.charAt(ind2)? 1:0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s1.charAt(ind1)==s2.charAt(ind2)){
             return dp[ind1][ind2]=1+ dfs(ind1-1,ind2-1, s1, s2, dp);
        }
        else{
            return dp[ind1][ind2]= Math.max(dfs(ind1-1,ind2, s1, s2, dp) , dfs(ind1,ind2-1, s1, s2, dp));
        }
         
    }
}