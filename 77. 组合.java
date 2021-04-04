class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrace(n, k, 1, path, paths);

        return paths;
    }

    private void backtrace(int n, int k, int start, List<Integer> path, List<List<Integer>> paths) {

        if (path.size() == k) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrace(n, k, i+1, path, paths);
            path.remove(path.size() - 1);
        }
    }
}