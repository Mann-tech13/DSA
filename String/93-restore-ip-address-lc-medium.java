// https://leetcode.com/problems/restore-ip-addresses/description/

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ls = new ArrayList<>();
        helper(s, ls, 0, "", 0);
        return ls;
    }

    public boolean isValidString(String s) {
        if(s.charAt(0) == '0' && s.length() > 1) return false;
        return Integer.parseInt(s) <= 255;
    }

    public void helper(String s, List<String> ls, int index, String curr, int dots) {
        if(index == s.length() && dots == 4) {
            ls.add(curr.substring(0, curr.length() - 1));
            return;
        }
        if(index + 1 <= s.length() && isValidString(s.substring(index, index + 1))) {
            helper(s, ls, index + 1, curr + s.substring(index, index + 1) + '.', dots + 1 );
        }
        if(index + 2 <= s.length() && isValidString(s.substring(index, index + 2))) {
            helper(s, ls, index + 2, curr + s.substring(index, index + 2) + '.', dots + 1 );
        }
        if(index + 3 <= s.length() && isValidString(s.substring(index, index + 3))) {
            helper(s, ls, index + 3, curr + s.substring(index, index + 3) + '.', dots + 1 );
        }
    }
}