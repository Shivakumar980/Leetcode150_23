class Solution {
    public int trap(int[] height) {
        
        int n= height.length;
        int[] prefixmap=new int[n];
        prefixmap[0]=height[0];
        for(int i=1;i<n;i++){
            prefixmap[i]=Math.max(height[i],prefixmap[i-1]);
        }
        int[] suffixmap=new int[n];
        suffixmap[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            suffixmap[i]=Math.max(height[i],suffixmap[i+1]);
        }
        int total=0;
        for(int i=0;i<n;i++){
            if(height[i]<prefixmap[i] && height[i]<suffixmap[i]){
                total= total+ Math.min(suffixmap[i],prefixmap[i])-height[i];
            }
        }
        return total;
    }
}