class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> paths = new ArrayList<>();
        if (candidates.length == 0) {
            return paths;
        }

        List<Integer> path = new ArrayList<>();

        Arrays.sort(candidates);

        backtrace(candidates, target, 0, path, paths);

        return paths;
    }

    private void backtrace(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> paths) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            backtrace(candidates, target - candidates[i], i+1, path, paths);
            path.remove(path.size() - 1);
        }
    }
}