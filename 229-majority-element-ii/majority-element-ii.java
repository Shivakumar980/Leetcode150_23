class Solution {
    public List<Integer> majorityElement(int[] nums) {
         List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        int cnt1=0,cnt2=0;
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(cnt1==0 && el2!=nums[i]){
                cnt1++;
                el1=nums[i];
            }
            else if(cnt2==0 && el1!=nums[i]){
                cnt2++;
                el2=nums[i];
            }
            else if(nums[i]==el1){
                cnt1++;
            }
            else if(nums[i]==el2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }

        }
        cnt1=0;
        cnt2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==el1){
                cnt1++;
            }
            else if(nums[i]==el2){
                cnt2++;
            }
        }
        System.out.println(cnt1);
        System.out.println(cnt2);
        if(cnt1>n/3) ans.add(el1);
        if(cnt2>n/3) ans.add(el2);
        return ans;
    }
}