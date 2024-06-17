class Solution {
    public int maxProfit(int[] prices) {
        int max=Integer.MIN_VALUE;
        int n=prices.length;
        int buy_price=prices[0];
        for(int i=1;i<n;i++){
                int price=prices[i]-buy_price;
                max=Math.max(price,max); 
                buy_price=Math.min(buy_price,prices[i]); 
        }
        if(max<0) return 0;
        return max;
    }
}