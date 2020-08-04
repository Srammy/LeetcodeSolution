class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int zeroCount = 0; // 统计grid中0的个数
        Queue<int[]> q = new LinkedList<>();
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int level = -1;
        int everyLevelSize = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j] == 0) {
                    zeroCount++;
                }
            }
        }

        if(zeroCount == m * n) return 0; //grid全是0
        if(q.isEmpty()) return -1; //grid全是1，或者全是0和1
        while(!q.isEmpty()) {
            level++;
            everyLevelSize = q.size();
            for(int k = 0; k < everyLevelSize; k++) {
                int[] cur = q.poll();
                for(int[] move : moves) {
                    int nextR = cur[0] + move[0];
                    int nextC = cur[1] + move[1];

                    if(checkBound(m, n, nextR, nextC) && grid[nextR][nextC] == 1) {
                        grid[nextR][nextC] = 2;
                        q.add(new int[]{nextR, nextC});
                    }
                }

            }
        }
        // 层序遍历结束后，还有1，也就是还有橘子无法腐烂，返回-1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return level;
    }

    private boolean checkBound(int m, int n, int nextR, int nextC) {
        return nextR >= 0 && nextR < m && nextC >= 0 && nextC < n;
    }
}