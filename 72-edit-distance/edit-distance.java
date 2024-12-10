class Solution {

    private int editUtil(int ind1, int ind2, String s1, String s2,int[][] dp){
        if(ind1<0){
            return ind2+1;
        }
        if(ind2<0){
            return ind1+1;
        }

        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
            }
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return dp[ind1][ind2]= editUtil(ind1-1, ind2-1, s1, s2, dp);
        }
        else{
            return dp[ind1][ind2]=  Math.min( 1+ editUtil(ind1-1,ind2,s1,s2,dp),Math.min( 1+editUtil(ind1,ind2-1,s1,s2,dp) , 1+editUtil(ind1-1,ind2-1,s1,s2,dp)));
        }
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1][n2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return editUtil(n1 - 1, n2 - 1, word1, word2, dp);
    }
}