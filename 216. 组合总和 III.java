class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrace(k, n, 1, path, paths);

        return paths;
    }

    private void backtrace(int k, int n, int start, List<Integer> path, List<List<Integer>> paths) {
        if (n < 0) {
            return;
        }
        
        if (n == 0 && path.size() == k) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (i > 9) {
                break;
            }

            path.add(i);
            backtrace(k, n - i, i+1, path, paths);
            path.remove(path.size() - 1);
        }
    }
}