class Solution {
    private int calculate(int mid,int[] piles){
        double k=0.0;
        for(int i=0;i<piles.length;i++){
            k+=Math.ceil((double)piles[i]/mid);
        }
        return (int)k;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
       // if(n==1) return (int)Math.ceil((double)piles[0]/h);
        int maxpile=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxpile=Math.max(maxpile,piles[i]);
        }
        int low=1;
        int high=maxpile;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int k=calculate(mid,piles);
            if(k<=h){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}