// https://leetcode.com/problems/permutation-sequence/description/

class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> ls = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            fact *= i;
            ls.add(i);
        }
        ls.add(n);
        String ans = "";
        k -= 1;
        while(true) {
            ans += ls.get(k / fact);
            ls.remove(k / fact);
            if(ls.size() == 0) break;
            k %= fact;
            fact /= ls.size();
        } 
        return ans;
    }
}