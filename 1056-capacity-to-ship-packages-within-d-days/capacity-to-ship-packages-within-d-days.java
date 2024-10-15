class Solution {
    private int calculate(int[] weights,int mid){
        int days=1;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            if(sum>mid){
                days++;
                sum=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int minDays=calculate(weights,mid);
            
             if(minDays<=days){
                ans=mid;
                high=mid-1; 
            }
            else{
                low=mid+1;
            }
            
        }
        return ans;
    }
}