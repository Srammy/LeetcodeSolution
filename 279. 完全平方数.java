class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            if (isSquare(i)) { // 如果这个数本身就是完全平方数的话，就只需要这个数本身
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);
            }
            
        }

        return dp[n];
    }


    public static boolean isSquare(int num) {
        double a = 0;
        try {
            a = Math.sqrt(num);	
        } catch (Exception e) {
            return false;
        }
        int b = (int) a;
        return a - b == 0;
    }
}