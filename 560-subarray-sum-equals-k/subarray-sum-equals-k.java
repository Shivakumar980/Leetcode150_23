class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm= new HashMap<>();

        int sum=0;
        int n= nums.length;
        int count=0;
        for(int i=0; i< n ;i++){
            sum+=nums[i];
            if(sum==k){
                count++;
            }

            int rem= sum-k;
            if(hm.containsKey(rem)){
                count+=hm.get(rem);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }

        return count;
    }
}