// https://leetcode.com/problems/permutations-ii/description/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Boolean> track = new HashMap<>();
        Set<List<Integer>> distinctPairs = new HashSet<>();
        permutaionPairs(ls, distinctPairs, nums, track);
        return new ArrayList<>(distinctPairs);
    }
    public void permutaionPairs(List<Integer> ls, Set<List<Integer>> distinctPairs, int[] nums, Map<Integer, Boolean> track) {
        if(ls.size() == nums.length) {
            distinctPairs.add(new ArrayList<>(ls));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(track.containsKey(i) && track.get(i)) continue;
            track.put(i, true);
            ls.add(nums[i]);
            permutaionPairs(ls, distinctPairs, nums, track);
            ls.remove(ls.size() - 1);
            track.put(i, false);
        }
    }
}