// https://leetcode.com/problems/maximum-gap/description/

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (max - min == 0) return 0;

        int bucketSize = (int) Math.ceil((double)(max - min) / (nums.length - 1));

        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int num : nums) {
            if (num == min || num == max) continue;
            int index = (num - min) / bucketSize;
            bucketMin[index] = Math.min(num, bucketMin[index]);
            bucketMax[index] = Math.max(num, bucketMax[index]);
        }

        int maxGap = 0, prev = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prev);
            prev = bucketMax[i];
        }

        maxGap = Math.max(maxGap, max - prev);
        return maxGap;
    }
}
