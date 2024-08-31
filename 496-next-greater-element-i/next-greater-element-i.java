class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> hm= new HashMap<>();
        int[] res=new int[nums1.length];
        for(int n2:nums2){
            while(!st.isEmpty() && n2>st.peek()){
                hm.put(st.pop(),n2);
            }
            st.push(n2);
        }
        while(!st.isEmpty()){
            hm.put(st.pop(),-1);
        }
        int index=0;
        for(int n1:nums1){
            res[index++]=hm.get(n1);
        }
        return res;
    }
}