// https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, area = 0;
        while(left < right) {
            int minHeight = Math.min(height[left], height[right]);
            area = Math.max(area, minHeight * (right - left));
            if(height[left] < height[right]) left++;
            else right--;
        }
        return area;
    }
}