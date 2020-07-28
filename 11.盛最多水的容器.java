/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = 0;
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            if (currentArea > max) {
                max = currentArea;
            }

            // 移动短板
            if (height[left] < height[right]) {
                left++;
            } else {
                right --;
            }
        }
        return max;
    }
}
// @lc code=end

