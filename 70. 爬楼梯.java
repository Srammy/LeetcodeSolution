class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        Map<Integer, Integer> memory = new HashMap<>();
        return helper(n, memory);
    }

    private int helper(int n, Map<Integer, Integer> memory) {
        if (n == 1 || n == 2) {
            memory.put(n, n);
            return n;
        }

        if (memory.containsKey(n)) {
            return memory.get(n);
        }

        memory.put(n, helper(n - 1, memory) + helper(n - 2, memory));
        return memory.get(n);
    }
}