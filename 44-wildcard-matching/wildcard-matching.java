class Solution {

    private boolean isMatchUtil(int ind1, int ind2 , String s, String p, int[][] dp){
        if(ind1<0 && ind2<0) return true;
        if(ind1<0){
            for(int i=0;i<=ind2;i++){
                if(p.charAt(i)!='*'){
                    return false;
                }
               
            }
             return true;
        }
        if(ind2<0 &&ind1>=0) return false;
        

        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2]==1 ? true:false;
        }

        if(s.charAt(ind1)==p.charAt(ind2)|| p.charAt(ind2)=='?'){
            
            
             dp[ind1][ind2]=  isMatchUtil(ind1-1, ind2-1, s, p, dp)==true ? 1:0;
        }
        else if(p.charAt(ind2)=='*'){
             dp[ind1][ind2]= isMatchUtil(ind1-1, ind2, s, p, dp) ||
              isMatchUtil(ind1, ind2-1, s, p, dp) == true ? 1 : 0;
        }
        else{
             dp[ind1][ind2]=0;
        }
        return dp[ind1][ind2]==1;
    }
    public boolean isMatch(String s, String p) {
        int n1=s.length();
        int n2=p.length();

        int[][] dp=new int[n1][n2];

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return isMatchUtil(n1-1, n2-1, s, p, dp);

        
    }
}