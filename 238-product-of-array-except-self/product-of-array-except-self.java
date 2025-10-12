class Solution {
    public int[] productExceptSelf(int[] nums) {
        

        int n= nums.length;
        
        int[] pre= new int[n];
        int[] post= new int[n];
        int[] res= new int[n];

        int prefix =1;

        for(int i=0 ; i< n ; i++){
            pre[i]= prefix;
            prefix*=nums[i];
        }

        int postfix =1;

        for( int i=n-1 ; i>-1 ; i--){
            post[i]=postfix;
            postfix*=nums[i];
        }

        for(int i=0; i< n ;i++){
            res[i]= pre[i]*post[i];
        }

        return res;


    }
}



