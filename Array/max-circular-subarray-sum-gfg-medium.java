// https://www.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1

class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
        int maxSumNonCircular = maxSum(arr);
        int total = 0;
        
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        
        int minSumSubArr = minSum(arr);
        int maxSumCircular = total - minSumSubArr;
        
        if(maxSumCircular == 0) return maxSumNonCircular;
        
        return Math.max(maxSumNonCircular, maxSumCircular);
    }
    public int maxSum(int arr[]) {
        int sum = arr[0];
        int end = arr[0];
        for(int i = 1; i < arr.length; i++){
            end = Math.max(end + arr[i], arr[i]);
            sum = Math.max(sum, end);
        }
        return sum;
    }
    public int minSum(int arr[]) {
        int sum = arr[0];
        int end = arr[0];
        for(int i = 1; i < arr.length; i++){
            end = Math.min(end + arr[i], arr[i]);
            sum = Math.min(sum, end);
        }
        return sum;
    }
}
