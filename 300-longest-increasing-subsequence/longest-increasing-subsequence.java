class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0 || n==1) return n;
        int[] dist= new int[n];
        Arrays.fill(dist,1);

        int maxval= (int)-1e6;
        for(int ind=1; ind <n; ind++){
            for(int prev=0 ; prev<ind; prev++ ){
                if(nums[prev]<nums[ind] && 1+ dist[prev]> dist[ind]){
                    dist[ind]=1+dist[prev];
                }
                maxval=Math.max(maxval, dist[ind]);
            }
        }
       
        return maxval;
    }
}