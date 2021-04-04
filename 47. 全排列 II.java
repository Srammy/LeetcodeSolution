class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> paths = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        dfs(nums, 0, paths, path, visited);

        return new ArrayList<>(paths);
    }

    private void dfs(int[] nums, int index, Set<List<Integer>> paths, List<Integer> path, boolean[] visited) {
        if (index == nums.length) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }

            visited[i] = true;
            path.add(nums[i]);
            dfs(nums, index + 1, paths, path, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}