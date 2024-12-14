class Solution {
     private int lowerBound(ArrayList<Integer> arr, int k){
        int low=0;
        int high=arr.size();

        while(low<=high){
            int mid= low+ (high-low)/2;
            if(arr.get(mid)<k){
                low= mid+1;
            }
            else{
                high= mid-1;
            }
        }
        return low;
    }

    public int lengthOfLIS(int[] nums) {
            int n=nums.length;
            ArrayList<Integer> al=new ArrayList<>();
            int maxlen=1;
            al.add(nums[0]);
            for(int i=1;i<n;i++){
                if(nums[i]>al.get(al.size()-1)){
                    al.add(nums[i]);
                    maxlen++;
                    System.out.println(al);
                }
                else{
                    int idx= lowerBound(al, nums[i]);
                    al.set(idx, nums[i]);
                    
                }
            }
            
        
         return maxlen;
    }

   
}