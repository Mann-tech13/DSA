// https://leetcode.com/problems/combination-sum-iii/description/
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        generate(ls, n, k, 1, res);
        return res;
    }
    public void generate(List<Integer> ls, int n, int k, int start, List<List<Integer>> res) {
        if(k == 0 && n == 0) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = start; i <= 9; i++) {
            if(i > n || k <= 0) break;
            ls.add(i);
            generate(ls, n - i, k - 1, i + 1, res);
            ls.remove(ls.size() - 1);
        }
    }
}
