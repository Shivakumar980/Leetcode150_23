class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int n=n1+n2;

        int index2=n/2;
        int index1=index2-1;
        int cnt=0;

        int ind1el=-1;
        int ind2el=-1;

        int i=0;
        int j=0;

        while(i<n1 &&j<n2){
            if(nums1[i]<nums2[j]){
                if(cnt==index1) ind1el=nums1[i];
                if(cnt==index2) ind2el=nums1[i];
                i++;
            }
            else{
                if(cnt==index1) ind1el=nums2[j];
                if(cnt==index2) ind2el=nums2[j];
                j++;
            }
            cnt++;
        }
        while(i<n1){
            if(cnt==index1) ind1el=nums1[i];
            if(cnt==index2) ind2el=nums1[i];
            cnt++;
                i++;
        }

         while(j<n2){
            if(cnt==index1) ind1el=nums2[j];
            if(cnt==index2) ind2el=nums2[j];
            cnt++;
                j++;
        }

        if(n%2==1){
            return (double)ind2el;
        }
        else{
            return (double)((double)(ind1el+ind2el))/2.0;
        }
   
    }
}