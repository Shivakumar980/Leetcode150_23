import java.util.Arrays;

class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        // Base case: if there are fewer than 2 steps
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        
        // Create an array to store the minimum cost to reach each step
        int[] dp = new int[n];
        
        // Initialize base cases
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        // Fill the dp array
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        // The minimum cost to reach the top is the minimum of the last two steps
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
