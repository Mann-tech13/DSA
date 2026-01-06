// https://www.geeksforgeeks.org/problems/key-pair5616/1

class Solution {
    boolean twoSum(int nums[], int target) {
        // code here
        Set<Integer> set = new HashSet<Integer>();;
        for(int i = 0; i < nums.length; i++){
            int tempTarget = target - nums[i];
            if(set.contains(tempTarget)) return true;
            else set.add(nums[i]);
        }
        return false;
    }
}