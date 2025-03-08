class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n= nums.length;
        int[] prefix=new int[n];
        Arrays.fill(prefix,nums[0]);
        int[] postfix=new int[n];
        Arrays.fill(postfix,nums[n-1]);

        for(int i=1; i<n; i++){
            int j= n-1-i;
            prefix[i]= prefix[i-1]*nums[i];
            postfix[j]=postfix[j+1]*nums[j];
        }

        int[] result= new int[n];
        result[0] = postfix[1]; 
        result[n - 1] = prefix[n - 2];
        for(int i=1 ;i<n-1 ;i++){
            result[i]= prefix[i-1]*postfix[i+1];
        }
        return result;
    }
}