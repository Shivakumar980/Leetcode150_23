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
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] presum=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=matrix[i][j]-'0';
                if(matrix[i][j]-'0'==0){
                    sum=0;
                }
                presum[i][j]=sum;
            }

        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            int area=largestRectangleArea(presum[i]);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}