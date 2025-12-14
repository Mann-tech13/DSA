class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 1, expectedSum = 0, cumSum = 0;
        for (int i = 0; i < arr.length; i++) {
            expectedSum += i;
            cumSum += arr[i];
            if(expectedSum == cumSum) chunks++;
        }
        return chunks - 1;
    }
}