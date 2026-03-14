class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int num: nums) {
            set.add(num);
        }
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i] - 1)) continue;
            int len = 1;
            while(set.contains(nums[i] + len)) {
                len++;
            }
            max = Math.max(len, max);
        }
        return max;
    }
}
