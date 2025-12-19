// https://www.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal4142/1

class Solution {
    boolean findSwapValues(int[] a, int[] b) {
        // Your code goes here
        int sumA = 0, sumB = 0;
        for(int i = 0; i < a.length; i++) {
            sumA += a[i];
        }
        for(int i = 0; i < b.length; i++) {
            sumB += b[i];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int target = sumA - sumB;
        if(target % 2 != 0) return false;
        target /= 2;
        int i = 0, j = 0;
        while(i < a.length && j < b.length) {
            int diff = a[i] - b[j];
            if(target == diff) return true;
            else if(target > diff) i++;
            else j++;
        }
        return false;
    }
}
