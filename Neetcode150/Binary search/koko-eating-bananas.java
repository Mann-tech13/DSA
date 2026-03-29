class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int upperBound = 0;
        for(int i: piles) {
            upperBound = Math.max(upperBound, i);
        }
        if(h == piles.length) return upperBound;
        int left = 1, ans = upperBound;
        while(left <= upperBound) {
            int k = left + (upperBound - left) / 2;
            int totalHours = 0;
            for(int i: piles) {
                totalHours += Math.ceil((double)i / k);
            }
            if(totalHours <= h) {
                ans = k;
                upperBound = k - 1;
            } else left = k + 1;

        }
        return ans;
    }
}
