class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            int[] freq = new int[26];
            for(char ch: strs[i].toCharArray()) {
                freq[ch - 'a']++;
            }
            String key = Arrays.toString(freq);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
