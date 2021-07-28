class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        
        while(true) {
            for(int i = l; i <= r; i++) res.add(matrix[t][i]); // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res.add(matrix[i][r]); // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res.add(matrix[b][i]); // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res.add(matrix[i][l]); // bottom to top.
            if(++l > r) break;
        }
        return res;
    }
}