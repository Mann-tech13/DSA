// https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1
class Solution {
    int missingNum(int arr[]) {
        int xor = 0, n = arr.length + 1;
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        for (int num : arr) {
            xor ^= num;
        }
        return xor;
    }
}