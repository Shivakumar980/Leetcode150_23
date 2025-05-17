class Solution {
    public int trap(int[] height) {
        
        int n=height.length;
        int leftmax=0;
        int rightmax=0;
        int left=0;
        int right=n-1;

        int area=0;
        while(left<=right){
            if(leftmax<rightmax){
                leftmax=Math.max(leftmax, height[left]); //to avoaid writing area>=0, we are updating left max
                area+= leftmax-height[left];
                left++;
            }
            else{
                 rightmax=Math.max(rightmax, height[right]);
                 area+= rightmax- height[right];
                 right--;
            }
        }
        return area;
    }
}