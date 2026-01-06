// https://leetcode.com/problems/combinations/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ls = new ArrayList<>();
        generate(ls, n, k, 0);
        return res;
    }
    public void generate(List<Integer> ls, int n, int k, int start) {
        if(k == 0) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i = start + 1; i <= n; i++) {
            ls.add(i);
            generate(ls, n, k - 1, i);
            ls.remove(ls.size() - 1);
        }
    }
}