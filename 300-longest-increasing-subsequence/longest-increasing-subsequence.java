class Solution {

    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] curr=new int[n+1];
        int[] next=new int[n+1];

        for(int ind=n-1; ind>=0; ind--){
            for(int prev=ind-1; prev>=-1; prev--){
                int not_take=next[prev+1];
                int take=0;
                if( prev==-1 || nums[ind]>nums[prev]){
                        take= 1+ next[ind+1];
                }
                curr[prev+1]=Math.max(take,not_take);
                }  
                next=curr;
            }
           
             return curr[0];
        }
       
    }
