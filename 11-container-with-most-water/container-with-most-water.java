class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int start=0;
        int end= n-1;
        int maxarea=0;
      
        while(start<end){
            int area= (end-start)* Math.min(height[start], height[end]);
            maxarea= Math.max(area, maxarea);
            if(height[start]<height[end]){
                start++;
            }
            else{
                end--;
            }
            
        }
        return maxarea;
        
    }
}