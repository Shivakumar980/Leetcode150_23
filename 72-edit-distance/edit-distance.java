class Solution {
    public int minDistance(String word1, String word2) {
        int n1= word1.length();
        int n2= word2.length();
        int[][] dp= new int[n1][n2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return backtrack(n1-1, n2-1 , dp, word1, word2 );
    }

    private int backtrack(int ind1, int ind2, int[][] dp, String s, String t){
        if(ind1<0){
            return ind2+1;
        }
        if(ind2<0){
            return ind1+1;
        }

        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1)==t.charAt(ind2)){
            dp[ind1][ind2]= backtrack(ind1-1, ind2-1, dp, s, t);
        }
        else{
            dp[ind1][ind2]= Math.min(1+backtrack(ind1, ind2-1, dp, s, t) ,
            Math.min(1+backtrack(ind1-1, ind2, dp, s, t), 1+backtrack(ind1-1, ind2-1, dp, s, t)));
        }
        return dp[ind1][ind2];
    }
}