// https://www.geeksforgeeks.org/problems/wave-array-1587115621/1?track=amazon-arrays&batchId=192
class Solution {
    public void sortInWave(int arr[]) {
        if(arr.length == 1) return;
        for(int i = 1; i < arr.length; i+=2) {
            if(i >= arr.length) break;
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
    }
}
