//--------------------- 方法1：递归------------------
class Solution {
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return  fib(n-1) + fib(n-2);
    }
}
//------------------- 方法2：备忘录递归----------------
class Solution {
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] memory = new int[n+1];
        return helper(n, memory);
    }

    private int helper(int n, int[] memory) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if(memory[n] != 0) return memory[n];
        memory[n] = helper(n-1, memory) + helper(n-2, memory);
        return memory[n];
    }
}
//----------------- 方法3：迭代循环 -----------------------
class Solution {
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int n1 = 1;
        int n2 = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }

        return sum;
    }

}