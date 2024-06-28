class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int index1=-1;
        int index2=-1;
        HashMap<Integer,Integer> hm=new HashMap();
        for(int i=0;i<n;i++){
            int remaining_sum=target-nums[i];
            if(hm.containsKey(remaining_sum)){
                index1=i;
                index2=hm.get(remaining_sum);
               
                break;
            }
            hm.put(nums[i],i);
           
        }
        /*for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if(sum==entry.getValue()){
                index2=entry.getKey();
            }
        }*/

        return new int[]{index1,index2};
    }
}