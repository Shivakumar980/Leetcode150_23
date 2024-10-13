class Solution {
    public int[] searchRange(int[] arr, int x) {
        Arrays.sort(arr);
        int last=-1;
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=x){
                //floor=arr[mid];
                low=mid+1;
            }else{
                high=mid-1;
            }
            if(arr[mid]==x){
            last=mid;
        }
        }
        
        
         low=0;
         high=arr.length-1;
        int first=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                //ceil=arr[mid];
                //System.out.println(ceil);
                high=mid-1;
            }
            else{
                low=mid+1;
            }
       if(arr[mid]==x){
           first=mid;
            
        }
        }
         
        return new int[]{first,last};
        
    }
}