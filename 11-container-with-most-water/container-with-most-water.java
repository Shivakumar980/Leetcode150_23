class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int area=0;
        while(left<right){
            int local_area= (right-left)* Math.min(height[right], height[left]);
            area=Math.max(local_area, area);
            if(height[left]<height[right]){
                left++;
            }
            else{
                
                right--;

            }
        }
        return area;
        
    }
}