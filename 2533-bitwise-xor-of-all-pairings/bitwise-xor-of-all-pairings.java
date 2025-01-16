class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        int xor=0;

        if(n1%2==1){
             for(int num:nums2){
                xor=xor^num;
            }
        }
       if(n2%2==1){
             for(int num:nums1){
                xor=xor^num;
            }
        }
        return xor;
    }
}