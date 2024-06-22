class Solution {
    public List<Integer> majorityElement(int[] nums) {
          int n=nums.length;
        List<Integer> ans=new ArrayList<>();

        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if(entry.getValue()>n/3){
                ans.add(entry.getKey());
            }
        }
        
        return ans;
           
      
    }


}