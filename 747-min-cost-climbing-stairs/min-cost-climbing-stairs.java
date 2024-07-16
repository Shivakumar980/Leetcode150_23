class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];

        int[] dp = new int[n + 1]; // dp[i] is the minimum cost to reach step i
        dp[0] = 0; // Starting step
        dp[1] = 0; // Starting step

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n]; // Minimum cost to reach the top
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] cost = {10, 15, 20};
        System.out.println(solution.minCostClimbingStairs(cost)); // Output: 15
    }
}
