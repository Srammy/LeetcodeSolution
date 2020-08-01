class Solution {
    public int maxDistance(int[][] grid) {
        int N = grid.length; // 可以理解为二维数组的行数
        int everyLevelSize = 0; // 每一层节点数量
        int level = -1; // BFS的层次
        Queue<int[]> q = new LinkedList<>(); // q中存放的每一个元素是一个一维数组（这个一维数组有两个元素），代表了是二维数组grid的索引

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 1){  // 把所有的陆地加到队列中，作为起点。就和二叉树层次遍历时，先把根节点加入到队列中是一样的
                    q.offer(new int[]{i, j}); // 多起点--->多源BFS
                }
            }
        }

        // 全是陆地和海洋
        if(q.isEmpty() || q.size() == N * N) {
            return -1;
        }

        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        while(!q.isEmpty()) {
            level++; // 增加层数
            everyLevelSize = q.size();
            for(int i = 0; i < everyLevelSize; i++) {
                int[] cur = q.poll(); // 当前遍历
                int r = cur[0]; // 当前遍历到的点，在二维数组中的一维（行）索引
                int c = cur[1]; // 当前遍历到的点，在二维数组中的二维（列）索引
                grid[r][c] = 2; // 将值置为2，表明该点已被遍历到

                // 左边的点
                if(r - 1 >= 0 && grid[r - 1][c] == 0) {
                    grid[r - 1][c] = 2;
                    q.offer(new int[]{r - 1, c});
                }
                // 右边的点
                if(r + 1 < N && grid[r + 1][c] == 0) {
                    grid[r + 1][c] = 2;
                    q.offer(new int[]{r + 1, c});
                }
                // 上方的点
                if(c - 1 >= 0 && grid[r][c - 1] == 0) {
                    grid[r][c - 1] = 2;
                    q.offer(new int[]{r, c - 1});
                }
                // 下方的点
                if(c + 1 < N && grid[r][c + 1] == 0) {
                    grid[r][c + 1] = 2;
                    q.offer(new int[]{r, c + 1});
                }
            }
        }
        return level;
    }
}