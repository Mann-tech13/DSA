// https://leetcode.com/problems/isomorphic-strings/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if (set.contains(t.charAt(i))) return false; // if value in t si aleady assigned to any key in s
                map.put(s.charAt(i), t.charAt(i));
            }
            set.add(t.charAt(i));
        }
        return true;

    }
}