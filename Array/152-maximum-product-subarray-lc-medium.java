// https://leetcode.com/problems/maximum-product-subarray/

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProd = 1;
        int rightProd = 1;
        int maxProd = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            leftProd *= nums[i];
            maxProd = Math.max(maxProd, leftProd);
            if (nums[i] == 0) {
                leftProd = 1;
                maxProd = Math.max(maxProd, 0);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            rightProd *= nums[i];
            maxProd = Math.max(maxProd, rightProd);

            if (nums[i] == 0) {
                rightProd = 1;
                maxProd = Math.max(maxProd, 0);
            }
        }
        return maxProd;
    }
}
