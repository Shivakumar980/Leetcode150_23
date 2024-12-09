class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int n1=str1.length();
        int n2=str2.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int ind1=1; ind1 <=n1 ;ind1++){
            for(int ind2=1; ind2 <=n2 ;ind2++){
                
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){
                    dp[ind1][ind2]= 1+ dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2]= Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        }

        StringBuilder s= new StringBuilder();
        
        int i=n1;
        int j=n2;

        while(i>0 && j>0){
            if(str1.charAt(i-1)== str2.charAt(j-1)){
                s.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                s.append(str1.charAt(i-1));
                i--;
            }
            else{
                s.append(str2.charAt(j-1));
                j--;
            }
        }
        while(j>0) {
            s.append(str2.charAt(j-1));
            j--;
            }
        while(i>0) {
            s.append(str1.charAt(i-1));
            i--;
        }

        return s.reverse().toString();
    }
}