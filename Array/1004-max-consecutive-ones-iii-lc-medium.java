//  https://leetcode.com/problems/max-consecutive-ones-iii/description/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, max = 0, swaps = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                swaps++;
            }
            while(swaps > k) {
                if(nums[left] == 0) swaps--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}