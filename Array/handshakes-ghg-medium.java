// User function Template for Java
// https://www.geeksforgeeks.org/problems/handshakes1303/1
class Solution {
    static int count(int N) {
        // code here
        if(N % 2 != 0) return 0;
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for(int i = 2; i <= N; i+=2 ) {
            for(int j = 0; j <= i - 2; j+=2) {
                dp[i] += dp[j] * dp[i - 2 - j];
            }
        }
        return dp[N];
    }
};