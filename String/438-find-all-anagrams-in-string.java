// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        if(p.length() > s.length()) return ls;

        Map<Character, Integer> pmap = new HashMap<Character, Integer>();
        for(char c: p.toCharArray()) pmap.put(c, pmap.getOrDefault(c, 0) + 1);
        Map<Character, Integer> trackp = new HashMap<>();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);

            if (pmap.containsKey(endChar)) {
                trackp.put(endChar, trackp.getOrDefault(endChar, 0) + 1);
            }

            if (end - start + 1 > p.length()) {
                char startChar = s.charAt(start);
                if (pmap.containsKey(startChar)) {
                    trackp.put(startChar, trackp.get(startChar) - 1);
                    if (trackp.get(startChar) == 0) {
                        trackp.remove(startChar);
                    }
                }
                start++;
            }
            if (end - start + 1 == p.length() && trackp.equals(pmap)) {
                ls.add(start);
            }
        }
        return ls;
    }
}