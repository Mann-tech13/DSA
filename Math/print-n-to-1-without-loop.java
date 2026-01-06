// https://www.geeksforgeeks.org/problems/print-n-to-1-without-loop/1
class Solution {
    void printNos(int N) {
        // code here
        if(N == 0) return;
        System.out.print(N + " ");
        printNos(N - 1);
    }
}