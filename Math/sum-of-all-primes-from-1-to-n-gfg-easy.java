// https://www.geeksforgeeks.org/problems/sum-of-all-prime-numbers-between-1-and-n4404/1
class Solution {
    public int prime_Sum(int n) {
        // code here
        int[] prime = new int [n + 1];
        for(int i = 0; i <= n; i++) {
            prime[i] = 1;
        }
        prime[0] = 0;
        prime[1] = 0;
        int sum = 0;
        for(int i = 2; i * i <= n; i++) {
            if(prime[i] == 1) {
                for(int j = i * i; j <= n; j+=i) {
                    prime[j] = 0;
                }
            }
        }
        for(int i = 2; i <= n; i++) {
            if(prime[i] == 1) sum += i;
        }
        return sum;
    }
}