class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm=new HashMap<>();
       
        int sum = 0;
        int count=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=sum-k;
            if(sum==k){
                count++;
            }
            if(hm.containsKey(rem)){
                count+=hm.get(rem);
            }

            hm.put(sum,hm.getOrDefault(sum,0)+1);

        }
        return count;

    }
}