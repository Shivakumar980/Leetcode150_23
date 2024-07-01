class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n=arr.length;
        for(int i=1;i<n-1;i++){
            int first=i-1;
            int last=i+1;
            if(arr[first]%2!=0 && arr[i]%2!=0 && arr[last]%2!=0){
                return true;
            }
            else{
                continue;
            }
        }
        return false;
    }
}