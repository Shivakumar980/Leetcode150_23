class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int n=nums.length;
        HashMap<Integer, Integer> hm=new HashMap<>();
        int presum=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            presum+=nums[i];
            if(presum==goal){
                cnt++;
            }
            int rem=presum-goal;
            if(hm.containsKey(rem)){
                cnt+=hm.get(rem);
            }
            hm.put(presum,hm.getOrDefault(presum,0)+1);
        }
        return cnt;
    }
}