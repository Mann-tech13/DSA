class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = 0, left = 0, right = 0;
        while(right < s.length()) {
            if(map.containsKey(s.charAt(right))) left = Math.max(left, map.get(s.charAt(right)) + 1);
            map.put(s.charAt(right), right);
            len = Math.max(right - left + 1, len);
            System.out.println(len + " " + left + " " + right);
            right++;
            
        }
        return len;
    }
}
