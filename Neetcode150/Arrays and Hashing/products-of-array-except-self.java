class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            if(i == 0) {
                prefix[i] = nums[i];
                continue;
            }
            prefix[i] = prefix[i - 1] * nums[i];
        }
        for(int i = len - 1; i >= 0; i--) {
            if(i == len - 1) {
                suffix[i] = nums[i];
                continue;
            }
            suffix[i] = suffix[i + 1] * nums[i];
        }
        for(int i = 0; i < len; i++) {
            if(i == 0) res[i] = suffix[i + 1];
            else if(i == len - 1) res[i] = prefix[i - 1];
            else res[i] = prefix[i - 1] * suffix[i + 1];
        }
        return res;
    }
}  
