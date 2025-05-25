class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        if(n==1) return (int)Math.ceil((double)piles[0]/h);
        
        int low = 1;
        int high= Integer.MIN_VALUE;
        for(int pile : piles){
            high= Math.max(pile,high);
        }

        while(low<=high){
            int mid= low+(high-low)/2;

            double timetaken=0;
            for(int i=0; i< n;i++){
                timetaken+= (int)Math.ceil((double)piles[i]/mid);
            }

            if(timetaken> h){
                low=mid+1;
            }
            else if(timetaken<=h){
                high=mid-1;
            }

            
     }
      return low;
    }

    
}