class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            int ele = target - numbers[i];
            if(map.containsKey(ele)) return new int[]{map.get(ele), i + 1};
            else map.put(numbers[i], i + 1);
        }
        return new int[]{-1, -1};
    }
}
