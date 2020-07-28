/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {

        if(s == null || s == "") {
            return "";
        }

        int len = s.length();
        int i = 0; // 子串起始索引
        int j = 0; // 子串结束索引
        String res = "";
        boolean[][] isPalindromic = new boolean[len][len];
        
        for (i = len - 1; i >= 0; i--) {
            for (j = i; j < len; j++) {
                if (j - i == 0) { // 单个字符。肯定是回文
                    isPalindromic[i][j] = true;
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) { //两个相邻的字符，如果一样则是回文，例如 dd
                    isPalindromic[i][j] = true;
                } else if (isPalindromic[i+1][j-1] && s.charAt(i) == s.charAt(j)) { //aba是 abba是 cggd不是
                    isPalindromic[i][j] = true;
                }

                //对每一个子串进行判断
                if(isPalindromic[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j+1);
                }
            }

        }
        return res;
    }
}
// @lc code=end

