// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int start = 0, end = nums.length - 1, min = nums[0];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }
            if ((nums[start] <= nums[mid] && nums[mid] <= nums[end])
                    || (nums[mid] <= nums[end] && nums[start] >= nums[mid])) {
                min = Math.min(nums[end], min);
                end = mid - 1;
            } else {
                min = Math.min(nums[start], min);
                start = mid + 1;
            }
        }
        return min;
    }
}