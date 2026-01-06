// https://leetcode.com/problems/powx-n/description/

class Solution {
    public double myPow(double x, int n) {
        double res = 1.0, extra = 1.0;
        boolean fraction = false;
        if(n == 0 || x == 1) return res;
        if(x == 0) return 0.0;
        if(x == -1 && n % 2 == 0) return res;
        if(x == -1 && n % 2 != 0) return -1 * res;
        long exp = n;
        if(x < 0 && exp % 2 != 0) {
            x = Math.abs(x);
            res = -1.0;
        }
        if(exp < 0) {
            exp = Math.abs(exp);
            fraction = true;
        }
        while(exp != 1) {
            if(exp % 2 == 0) {
                x = x * x;
                exp = exp / 2;
            } else {
                extra = extra * x;
                exp = exp - 1;
            }
        }
        return fraction ? 1.0 / (res * x * extra) : res * x * extra;
    }
}