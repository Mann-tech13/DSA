class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char ch: t.toCharArray()) {
            if(map.containsKey(ch) && map.get(ch) <= 0) return false;
            else if(map.containsKey(ch) && map.get(ch) > 0) map.put(ch, map.get(ch) - 1);
            else return false;
        }
        for(int val: map.values()) {
            if(val > 0) return false;
        }
        return true;
    }
}
