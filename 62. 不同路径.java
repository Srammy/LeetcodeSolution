//---------------方法1：DFS(超出内存限制)-----------------------
class Solution {
    public int uniquePaths(int m, int n) {
        List<List<int[]>> paths = new ArrayList<>();
        List<int[]> path = new ArrayList<>();
        path.add(new int[]{0,0});

        boolean[][] visited  = new boolean[m][n];
        visited[0][0] = true;
        int[][] moves = new int[][]{{0, 1}, {1, 0}};

        dfs(visited, moves, 0, 0, m - 1, n - 1, paths, path);

        return paths.size();
    }

    private void dfs(boolean[][] visited, int[][] moves, int row, int col, int m, int n, List<List<int[]>> paths, List<int[]> path) {
        if (row == m && col == n) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int[] move : moves ) {
            int nextRow = row + move[0];
            int nextCol = col + move[1];

            if (!checkBound(nextRow, nextCol, m, n)) {
                continue;
            }

            visited[nextRow][nextCol] = true;
            path.add(new int[]{nextRow, nextCol});
            dfs(visited, moves, nextRow, nextCol, m, n, paths, path);
            visited[nextRow][nextCol] = false;
            path.remove(path.size() - 1);
        }
    }

    private boolean checkBound(int row, int col, int m, int n) {
        return row >= 0 && row <= m && col >= 0 && col <= n;
    }
}
//--------------------------方法2：动态规划---------------------
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}