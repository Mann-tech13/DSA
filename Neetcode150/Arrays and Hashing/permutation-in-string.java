class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int window = s1.length(), left = 0, right = s1.length();
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < window; i++) {
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (s1Map.equals(s2Map)) return true;
        while (right < s2.length()) {
            char ch = s2.charAt(right);
            s2Map.put(ch, s2Map.getOrDefault(ch, 0) + 1);

            char remove = s2.charAt(left);
            s2Map.put(remove, s2Map.get(remove) - 1);
            
            if (s2Map.get(remove) == 0) s2Map.remove(remove);
            left++;
            right++;
            if (s1Map.equals(s2Map)) return true;
        }

        return false;
    }
}