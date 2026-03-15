class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int left = 0, right = heights.length - 1;
        while(left < right) {
            int currentWaterLevel = (right - left) * Math.min(heights[left], heights[right]);
            maxWater = Math.max(maxWater, currentWaterLevel);
            if(heights[left] < heights[right]) left++;
            else if(heights[left] > heights[right]) right--;
            else {
                left++;
                right--;
            }
        }
        return maxWater;
    }
}
