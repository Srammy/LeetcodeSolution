//-----------------------------方法1：超时-------------------------
class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length() + 1; j++) {
                if (isPalindromic(s.substring(i, j))) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPalindromic(String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }
        return isPalindromic(str.substring(1, str.length() - 1)) && str.charAt(0) == str.charAt(str.length() - 1);
    }
}
//---------------------------------方法2：-----------------------------
class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
}