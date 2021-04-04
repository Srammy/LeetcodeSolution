class Solution {
    public int singleNumber(int[] nums) {
        int n = 0;
        for (int i : nums) {
            n = n ^ i;
        }
        return n;
    }
}