//-------------------方法1：快慢指针（找环）----------------
// 完全按照列表中找环入口的思路（可以比对一下代码）
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];

        // 找环
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // 找环的入口，也就是所求的重复值
        slow = 0;   // slow回到起点
        while (slow != fast) { // slow与fast相遇时，就是环的入口
            slow = nums[slow]; // slow一步一步得走
            fast = nums[fast]; // fast一步一步得走
        }

        return fast; // 或者 return slow;
    }
}
// 链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/

//---------------------方法2：二分法------------------
public class Solution {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right) >>> 1;
            
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }
}


//链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
