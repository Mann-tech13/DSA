// https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1
// User function Template for Java
class Solution {
    // Function for finding maximum and value pair
    int minSwap(int[] arr, int k) {
        // Complete the function
        int good = 0, bad = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= k) good++;
        }
        int minSwaps = good;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > k) bad++;
            if(i < good - 1) continue;
            else if(i == good - 1) minSwaps = Math.min(minSwaps, bad);
            else {
                if(arr[i - good] > k) bad--;
                minSwaps = Math.min(minSwaps, bad);
            }
        }
        return minSwaps;
    }
}
