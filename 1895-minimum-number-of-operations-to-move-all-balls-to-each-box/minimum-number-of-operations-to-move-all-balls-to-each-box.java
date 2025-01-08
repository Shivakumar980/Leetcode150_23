class Solution {
    public int[] minOperations(String boxes) {

        int n=boxes.length();

        int[] ans=new int[n];

        int ballsLeft=0;
        int movesLeft=0;
        int ballsRight=0;
        int movesRight=0;

        for(int i=0;i<n ;i++){
            ans[i]+= movesLeft;
            ballsLeft+=boxes.charAt(i)-'0';
            movesLeft+=ballsLeft;

            int j=n-i-1;
            ans[j]+=movesRight;
            ballsRight+= boxes.charAt(j)-'0';
            movesRight+= ballsRight;
        }
        return ans;
        
    }
}