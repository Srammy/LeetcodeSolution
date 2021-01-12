//-------------方法1：递归-----------------
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return dp(grid, m - 1, n - 1);
    }

    private int dp(int[][] grid, int m, int n) {
        
        // base case
        if (m == 0 && n == 0) {
            return grid[0][0];
        } 

        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }

        return Math.min(dp(grid, m - 1, n), dp(grid, m, n - 1)) + grid[m][n];
    }
}
//-------------方法2：带备忘录的递归------------------
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] memory = new int[m][n];
        for (int[] row : memory) {
            Arrays.fill(row, -1);
        }
        
        return dp(grid, m - 1, n - 1, memory);
    }

    private int dp(int[][] grid, int m, int n, int[][] memory) {
        
        // base case
        if (m == 0 && n == 0) {
            return grid[0][0];
        } 

        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }

        if (memory[m][n] != -1) {
            return memory[m][n];
        }

        memory[m][n] = Math.min(dp(grid, m - 1, n, memory), dp(grid, m, n - 1, memory)) + grid[m][n];
        return memory[m][n];
    }
}
//--------------------方法3：动态规划--------------------------
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // base case
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];        

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(
                    dp[i - 1][j],
                    dp[i][j - 1]
                ) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}