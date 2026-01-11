// https://leetcode.com/problems/combination-sum/description/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        combinations(ls, res, candidates,  target, 0);
        return res;
    }
    
    public void combinations(List<Integer> ls, List<List<Integer>> res, int[] candidates, int target, int index) {
        if(target == 0) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] <= target){
                ls.add(candidates[i]);
                combinations(ls, res, candidates,  target - candidates[i], index);
                ls.remove(ls.size() - 1);
            }
        }
    }

}