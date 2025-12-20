// https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        String lps = "";
        for (int i = 1; i < s.length(); i++) {
            int left = i, right = i;
            while ((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))) {
                left--;
                right++;
            }
            int len = right - left - 1;
            if (len > lps.length())
                lps = s.substring(left + 1, right);

            left = i - 1;
            right = i;
            while ((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))) {
                left--;
                right++;
            }
            len = right - left - 1;
            if (len > lps.length())
                lps = s.substring(left + 1, right);
        }
        return lps;
    }
}