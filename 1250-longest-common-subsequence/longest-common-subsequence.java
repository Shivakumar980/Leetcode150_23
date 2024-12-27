class Solution {

    public int longestCommonSubsequence(String s1, String s2) {

        int n1= s1.length();
        int n2= s2.length();

        int[] prev=new int[n2+1];
        int[] curr=new int[n2+1];

       for(int ind1=1; ind1<=n1 ;ind1++){
            for(int ind2=1;ind2<=n2 ; ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                        curr[ind2]=1+ prev[ind2-1];
                    }
                else{
                    curr[ind2]=Math.max(prev[ind2], curr[ind2-1]);
                }

            
       }
       prev= (int[]) (curr.clone());
       }
        return curr[n2];
        
    }
}