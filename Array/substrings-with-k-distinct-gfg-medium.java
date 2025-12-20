// https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1

class Solution {
    public int countSubstr(String s, int k) {
        if (k == 0) return 0;
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    private int countAtMostK(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, count = 0;

        for (int end = 0; end < s.length(); end++) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if (map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }
                start++;
            }

            // Number of substrings ending at 'end'
            count += end - start + 1;
        }

        return count;
    }
}
