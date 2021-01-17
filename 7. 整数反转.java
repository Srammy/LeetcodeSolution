class Solution {
    public int reverse(int x) {
        
        int pop = 0;
        int res = 0;

        while (x != 0) {
            pop = x % 10;
            x = x / 10;

            // 正数溢出
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            // 负数溢出
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            res = res * 10 + pop;
        }

        return res;
    }
}