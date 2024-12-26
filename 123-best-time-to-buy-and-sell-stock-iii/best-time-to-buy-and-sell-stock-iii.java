class Solution {

 
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] curr=new int[2][3];
        int[][] next=new int[2][3];
        

        for(int ind=n-1;ind>=0;ind--){
            for(int buy=1;buy>=0;buy--){
                for(int cap=2;cap>=1;cap--){

                    int profit=0;

                    if(buy==1){
                        profit=Math.max(-prices[ind]+next[0][cap], next[1][cap]);
                    }
                    else{
                        profit=Math.max(prices[ind]+next[1][cap-1],next[0][cap]);
                    }

                    curr[buy][cap]=profit;

                }
            }
            next=curr;
        }

        return curr[1][2];
    }
}