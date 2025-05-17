class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int area=0;
        while(left<right){
            int local_area=0;
            if(height[left]<height[right]){
                local_area= (right-left)*height[left];
                area=Math.max(local_area, area);
                left++;
            }
            else{
                local_area= (right-left)*height[right];
                area=Math.max(local_area, area);
                right--;

            }
        }
        return area;
        
    }
}