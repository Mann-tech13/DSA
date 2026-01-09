// https://leetcode.com/problems/binary-subarrays-with-sum/description/
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubArrays(nums, goal) - countSubArrays(nums, goal - 1);
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