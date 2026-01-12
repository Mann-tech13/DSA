// https://leetcode.com/problems/find-the-duplicate-number/description/
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}
// [1 3 3 3 4 5 6 7 8]

// [1 2 2 4 5 6]
// [1 2 3 4 4 6]
// [1 2 3 5 6 7 8 9 9 9]