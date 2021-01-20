//------------------------方法1----------------------
//转为字符串，然后判断字符串是否是回文串
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        return help(s);
    }

    private boolean help(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }

        return (s.charAt(0) == s.charAt(s.length() - 1)) && help(s.substring(1, s.length() - 1));
    }
}
//----------------------方法2：反转一半数字-------------------
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int rev = 0;
        int pop = 0;

        while (x > rev) {
            pop = x % 10;
            rev = rev * 10 + pop;
            x = x / 10;
        }

        return x == rev || x == rev / 10;
    }
}