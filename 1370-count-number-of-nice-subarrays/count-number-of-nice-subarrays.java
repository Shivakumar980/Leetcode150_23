class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }
            else{
                nums[i]=1;
            }
        }
        HashMap<Integer, Integer> hm=new HashMap<>();
        int presum=0;
        int count=0;
        for(int i=0;i<n;i++){
            presum+=nums[i];
            if(presum==k){
                count++;
            }
            int rem=presum-k;
            if(hm.containsKey(rem)){
                count+=hm.get(rem);
            }
            hm.put(presum,hm.getOrDefault(presum,0)+1);
        }
        return count;
    }
}