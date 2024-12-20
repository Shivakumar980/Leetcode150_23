class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]> heights[i]){
                int element=heights[st.pop()];
                int pse=st.isEmpty()? -1 :st.peek();
                maxArea=Math.max(maxArea ,element*(i-pse-1));
                System.out.println(maxArea + " "+ element);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse=n;
            int element=heights[st.pop()];
            int pse=st.isEmpty()? -1 :st.peek();
            maxArea=Math.max(maxArea ,element*(nse-pse-1));
        }
        return maxArea;
    }
}