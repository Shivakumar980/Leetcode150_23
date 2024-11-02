
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        HashMap<Integer,Integer> hm=new HashMap<>();

        Stack<Integer> st=new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
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

        int m=nums1.length;
       int[] res=new int[m];
       int index=0;

       for(int num:nums1){
        res[index++]=hm.get(num);
       }
        return res;
    }
}