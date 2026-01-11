// https://leetcode.com/problems/permutations/description/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Boolean> track = new HashMap<>();
        permutaionPairs(ls, res, nums, track);
        return res;
    }
    
    public void permutaionPairs(List<Integer> ls, List<List<Integer>> res, int[] nums, Map<Integer, Boolean> track) {
        if(ls.size() == nums.length) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(track.containsKey(nums[i]) && track.get(nums[i])) continue;
            track.put(nums[i], true);
            ls.add(nums[i]);
            permutaionPairs(ls, res, nums, track);
            ls.remove(ls.size() - 1);
            track.put(nums[i], false);
        }
    }
}