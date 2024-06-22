class Solution {
    private void merge(long[] nums,int low,int mid,int high){
         ArrayList<Long> temp = new ArrayList<>();
         int left=low;
         int right=mid+1;

         while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
            }
         }
         while(left<=mid){
                temp.add(nums[left]);
                left++;
         }
          while(right<=high){
                temp.add(nums[right]);
                right++;
         }
        for(int i=low;i<=high;i++){
            nums[i]=temp.get(i-low);
        }
    }
    private int countPairs(long[] nums,int low,int mid,int high){
         int right=mid+1;
         int cnt=0;
         for(int i=low;i<=mid;i++){
            while(right<=high && nums[i]>2*nums[right]){
                right++;
            }
            cnt+=(right-(mid+1));
         }
        return cnt;
    }

    private int mergeSort(long[] nums,int low,int high){
        int cnt=0;
        if(low>=high) return cnt=0;
        int mid=(low+high)/2;
        cnt+=mergeSort(nums,low,mid);
        cnt+=mergeSort(nums,mid+1,high);
        cnt+=countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return cnt;
    }
    public int reversePairs(int[] nums) {
           int n = nums.length;
        long[] longNums = new long[n];
        for (int i = 0; i < n; i++) {
            longNums[i] = nums[i];
        }
        return mergeSort(longNums, 0, n - 1);
    }
}