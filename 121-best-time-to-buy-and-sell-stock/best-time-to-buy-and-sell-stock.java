class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxx=0;
        int minn=prices[0];
        for(int i=1;i<n;i++){
            minn=Math.min(minn,prices[i]);
                maxx=Math.max(prices[i]-minn,maxx);
        }
        
        return maxx;
    }
}