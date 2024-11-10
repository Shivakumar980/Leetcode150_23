class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int leftsum=0;
        for(int i=0;i<k;i++){
                leftsum+=cardPoints[i];
            }
        if(n==k){
            return leftsum;
        }

        int rightsum=0;
        int right=n-1;
        int maxscore=leftsum;
        for(int i=k-1;i>=0;i--){
            leftsum-=cardPoints[i];
            rightsum+=cardPoints[right];
            right--;
            maxscore=Math.max(maxscore,leftsum+rightsum);
        }
        return  maxscore;
    }
}