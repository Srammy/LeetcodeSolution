class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // dp数组表示目标金额为i时，所需要的最少的硬币个数
        Arrays.fill(dp, amount + 1); // 初始化为amount + 1，相当于初始化为正无穷

        dp[0] = 0; 

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}