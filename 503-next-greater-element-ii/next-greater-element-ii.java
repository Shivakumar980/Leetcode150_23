class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i%n]=-1;
            }
            else{
                res[i%n]=st.peek();
            }
            st.push(nums[i%n]);
        }
        return res;
    }
}