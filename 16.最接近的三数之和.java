// 先排序，再使用双指针
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        int sum = 0;
        for (int i = 0; i < length; i++) {
			// 双指针
            int start = i + 1;
            int end = length - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }

                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else { // 此时sum = target，上面的res已经更新了
                    return sum;
                }
            }
        }

        return res;
    }
}

链接：https://leetcode-cn.com/problems/3sum-closest/solution/hua-jie-suan-fa-16-zui-jie-jin-de-san-shu-zhi-he-b/
