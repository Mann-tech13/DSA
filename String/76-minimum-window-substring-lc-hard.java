// https://leetcode.com/problems/minimum-window-substring/description/

class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> track = new HashMap<>();

        for(char ch: t.toCharArray()) tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        int left = 0, right = 0, validStart = 0;
        int reqLength = tmap.size(), minLen = Integer.MAX_VALUE;
        int matches = 0;
        String ans = "";
        while(right < s.length()) {
            char ch = s.charAt(right);
            track.put(ch, track.getOrDefault(ch, 0) + 1);
            if(tmap.containsKey(ch) && track.containsKey(ch) && tmap.get(ch).intValue() == track.get(ch).intValue()) matches++;
            while(matches == reqLength) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                char leftC = s.charAt(left);
                track.put(leftC, track.get(leftC) - 1);
                if (track.get(leftC) == 0) {
                    track.remove(leftC);
                }

                if (tmap.containsKey(leftC) &&
                    track.getOrDefault(leftC, 0) < tmap.get(leftC)) {
                    matches--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : ans;
    }
}
