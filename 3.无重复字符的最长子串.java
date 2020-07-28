/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res=0; // 最大长度
        int i = 0; // 窗口左索引
        int j = 0; // 窗口右索引
        //Set里面存放的是引用数据类型
        Set<Character> set = new HashSet<>();
        while(i < len && j < len) {
            //charAt返回字符串指定索引处的char值。这里用到了自动装箱
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, j - i); 
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}
// @lc code=end

