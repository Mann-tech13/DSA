// https://www.geeksforgeeks.org/problems/sum-of-subarrays2229/1
class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int sum = 0, n = arr.length;
        for(int i = 0; i < n; i++) {
            sum += arr[i] * (i + 1) * (n - i);
        }
        return sum;
    }
}
