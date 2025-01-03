class Solution {
    private boolean binarySearch(int[] row, int target){
        int low=0;
        int high=row.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(row[mid]==target) return true;
            else if(target<row[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            if(matrix[i][0]<=target && matrix[i][m-1]>=target){
                return binarySearch(matrix[i],target);
            }
        }
        return false;
    }
}