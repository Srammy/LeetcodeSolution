class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(nums, 0, paths, path);

        return paths;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> paths, List<Integer> path) {
        if (index == nums.length) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i : nums) {
            if (path.contains(i)) {
                continue;
            }

            path.add(i);
            dfs(nums, index + 1, paths, path);
            path.remove(path.size() - 1);
        }
    }
}