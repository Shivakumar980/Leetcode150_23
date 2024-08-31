class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length];
        int index=0;
        for(int n1:nums1){
            int sum=-1;
           
            int target=Integer.MAX_VALUE;
            for(int n2:nums2){
                if(n1==n2){
                     target=n1;
                }
                if(n2>target){
                     sum=n2;
                     break;
                }
            }
            res[index++]=sum;

        }
        return res;
        
    }
}