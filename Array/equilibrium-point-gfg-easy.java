// https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
class Solution {
    public static int findEquilibrium(int arr[]) {
        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                prefix[i] = arr[i];
                continue;
            }
            prefix[i] = arr[i] + prefix[i - 1];
        }
        for(int i = arr.length - 1; i >= 0; i--) {
            if(i == arr.length - 1) {
                suffix[i] = arr[i];
                continue;
            }
            suffix[i] = arr[i] + suffix[i + 1];
        }
        for(int i = 0; i < arr.length; i++) {
            if(prefix[i] == suffix[i]) return i;
        }
        return -1;
    }
}
