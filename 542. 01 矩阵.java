/**
 *单源BFS
 * 原数组中是0的点，距离就是0
 * 原数组中是1的点，每遇到一个（for循环遍历到），就从该点开始进行BFS，计算它到最近的 0 的距离
 */
//--------------方法1--------------------------
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] res = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) { // 原数组中是0的点，距离就是0
                    res[i][j] = 0;
                } else {
                    res[i][j] = disance(matrix, i, j); // 原数组中是1的点，每遇到一个（for循环遍历到），就从该点开始进行BFS，计算它到最近的 0 的距离
                }
            }
        }

        return res;
    }

    public int disance(int[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n]; // 标记数组中的点是否已被访问。true-->已访问；false---->未访问
        Queue<int[]> q = new LinkedList<>();
        int level = 0; // 距离
        int everyLevelSize = 0; // 每层点数
        q.offer(new int[]{i,j}); // 出发点
        while(!q.isEmpty()) {
            level++;
            everyLevelSize = q.size();
            for(int k = 0; k < everyLevelSize; k++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                visited[r][c] = true;

                // 当前点的上下左右是否有0，有的话，就直接返回level，也就是到最近的 0 的距离
                if(r - 1 >= 0 && visited[r-1][c] == false && matrix[r-1][c] == 0) {
                    return level;
                }
                if(r + 1 < m && visited[r+1][c] == false && matrix[r+1][c] == 0) {
                    return level;
                }
                if(c - 1 >= 0 && visited[r][c-1] == false && matrix[r][c-1] == 0) {
                    return level;
                }
                if(c + 1 < n && visited[r][c+1] == false && matrix[r][c+1] == 0) {
                    return level;
                }

                // 经过上面的判断，上下左右没有0，全是1，此时把周围的点，全部加到队列里
                if(r - 1 >= 0 && visited[r-1][c] == false && matrix[r-1][c] == 1) {
                    visited[r-1][c] = true;
                    q.offer(new int[]{r-1, c});
                }
                if(r + 1 < m && visited[r+1][c] == false && matrix[r+1][c] == 1) {
                    visited[r+1][c] = true;
                    q.offer(new int[]{r+1, c});
                }
                if(c - 1 >= 0 && visited[r][c-1] == false && matrix[r][c-1] == 1) {
                    visited[r][c-1] = true;
                    q.offer(new int[]{r, c-1});
                }
                if(c + 1 < n && visited[r][c+1] == false && matrix[r][c+1] == 1) {
                    visited[r][c+1] = true;
                    q.offer(new int[]{r, c+1});
                }
            }

        }
        return level;
    }
}
//------------方法2:将方法1中的条件判断抽取出一个方法-------------
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] res = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) { // 原数组中是0的点，距离就是0
                    res[i][j] = 0;
                } else {
                    res[i][j] = disance(matrix, i, j); // 原数组中是1的点，每遇到一个（for循环遍历到），就从该点开始进行BFS，计算它到最近的 0 的距离
                }
            }
        }

        return res;
    }

    private int disance(int[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n]; // 标记数组中的点是否已被访问。true-->已访问；false---->未访问
        Queue<int[]> q = new LinkedList<>();
        int level = 0; // 距离
        int everyLevelSize = 0; // 每层点数
        int[][] moves = {{-1, 0},{1, 0},{0, -1},{0, 1}}
        q.offer(new int[]{i,j}); // 出发点
        while(!q.isEmpty()) {
            level++;
            everyLevelSize = q.size();
            for(int k = 0; k < everyLevelSize; k++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                visited[r][c] = true;

                for(int[] move : moves) {
                    int nextR = r + move[0];
                    int nextC = c + move[1];
                    // 当前点的上下左右是否有0，有的话，就直接返回level，也就是到最近的 0 的距离
                    if(checkBoundAndVisited(m, n, nextR, nextC, visited) && matrix[nextR][nextC] == 0) {
                        return level;
                    }
                    // 经过上面的判断，上下左右没有0，全是1，此时把周围的点，全部加到队列里
                    if(checkBoundAndVisited(m, n, nextR, nextC, visited) && matrix[nextR][nextC] == 1) {
                        visited[nextR][nextC] = true;
                        q.offer(new int[]{nextR, nextC});
                    }
                }
            }

        }
        return level;
    }

    /**
     *
     * @param m 数组行数
     * @param n 数组列数
     * @param r 当前行数
     * @param c 当前列数
     * @param visited 访问数组
     * @return  true 符合要求；false 不符合要求
     */
    private boolean checkBoundAndVisited(int m, int n, int r, int c, boolean visited) {
        return r >= 0 && r < m && c >= 0 && c < n && visited[r][c] == false;
    }

}

//-------------方法3：多源BFS-----------------
/**
 * 这个多源BFS可以和1162.地图分析一起来看
 * 1162是一层一层的处理，最后得到的是一个最大的层数（最短路径里面的最大值）
 * 本题是一个点接一个点的进行处理，因为是要更新每一个点的距离
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数
        int[][] res = new int[m][n]; //最终结果
        int[][] moves = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};
        boolean[][] visited = new boolean[m][n]; // 访问数组
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    res[i][j] = 0;
                    visited[i][j] = true; // 标记为已访问
                    q.offer(new int[]{i,j}); // 先把所有的0，入队，作为起点
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            // 上下左右四个点
            for(int[] move : moves) {
                int nextR = cur[0] + move[0];
                int nextC = cur[1] + move[1];

                if(checkBoundAndVisited(m, n, nextR, nextC, visited)) {
                    visited[nextR][nextC] = true;
                    res[nextR][nextC] = res[cur[0]][cur[1]] + 1; // 更新距离
                    q.offer(new int[]{nextR, nextC}); // 入队
                }
            }
        }
        return res;
    }

    /**
     *
     * @param m 数组行数
     * @param n 数组列数
     * @param r 当前行数
     * @param c 当前列数
     * @param visited 访问数组
     * @return  true 符合要求；false 不符合要求
     */
    public boolean checkBoundAndVisited(int m, int n, int nextR, int nextC, boolean[][] visited) {
        return nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && visited[nextR][nextC] == false;
    }
}
//-----------------方法4:在方法3上的进一步更新，节省了空间-------------------------
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数
        int[][] moves = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    q.offer(new int[]{i,j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE; // 节省一个访问数组，未访问的地方为Integer.MAX_VALUE；节省一个结果数组，在原数组matrix上更新距离
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int[] move : moves) {
                int nextR = cur[0] + move[0];
                int nextC = cur[1] + move[1];

                if(checkBound(m, n, nextR, nextC) && matrix[nextR][nextC] == Integer.MAX_VALUE) {
                    matrix[nextR][nextC] = matrix[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nextR, nextC});
                }
            }
        }
        return matrix;
    }

    public boolean checkBound(int m, int n, int nextR, int nextC) {
        return nextR >= 0 && nextR < m && nextC >= 0 && nextC < n;
    }
}