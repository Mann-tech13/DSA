// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int max = 1;
        int start = 0, end = 0;
        while(end < s.length()){
            char ch = s.charAt(end);
            if(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                max = Math.max(max, end - start);
                start++;
                continue;
            }
            set.add(ch);
            end++;
        }
        max = Math.max(max, end - start);
        return max;
    }
}