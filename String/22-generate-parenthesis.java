// https://leetcode.com/problems/generate-parentheses/description/

class Solution {
    public List<String> generateParenthesis(int n) {
        String s = "";
        List<String> parenthesisList = new ArrayList<String>();
        generateRecursively(parenthesisList, s, 0, 0, n);
        return parenthesisList;
    }

    public void generateRecursively(List<String> res, String s, int left, int right, int n) {
        if(s.length() == n * 2) {
            res.add(s);
            return;
        }
        if(left < n) generateRecursively(res, s + "(", left + 1, right, n);
        if(right < left) generateRecursively(res, s + ")", left, right + 1, n);
    }
}
