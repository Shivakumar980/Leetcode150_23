class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        HashMap<Integer, Integer> hm=new HashMap<>();
        int[] res=new int[nums1.length];
        int index=0;
        int n=nums2.length;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                hm.put(nums2[i],-1);
            }
            else{
                hm.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
        }
        for(int n1:nums1){
            res[index++]=hm.get(n1);
        }
        return res;
    }
}