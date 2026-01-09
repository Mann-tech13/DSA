// https://leetcode.com/problems/count-number-of-nice-subarrays/description/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) nums[i] = 0;
            else nums[i] = 1; 
        }
        return countSubArrays(nums, k) - countSubArrays(nums, k - 1);
    }
    public int countSubArrays(int[] nums, int goal) {
        if(goal < 0) return 0;
        int count = 0, left = 0, right = 0, sum = 0;
        while(right < nums.length) {
            sum += nums[right];
            while(sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}