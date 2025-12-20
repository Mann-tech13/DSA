// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int abs = Math.abs(nums[i]);
            if(nums[abs - 1] < 0) {
                ls.add(abs);
            }
            nums[abs - 1] *= -1;
        }
        return ls;
    }
}