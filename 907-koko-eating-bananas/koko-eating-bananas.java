class Solution {

    private int calculate_hours(int[] piles , int k){
        double hours=0;
        for(int num: piles){
            hours+=Math.ceil((double)num/k);
        }
        return  (int)hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n= piles.length;
        int ans=0;
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int num: piles){
            high=Math.max(high, num);
        }
        
        while(low<=high){
            int mid= low+ (high-low)/2;
            
            int hours= calculate_hours(piles, mid);

            if(hours> h){
                low = mid+1;
            }
            else{
                ans=mid;
                high=mid-1;
            }

        }
        return ans;

    }
}