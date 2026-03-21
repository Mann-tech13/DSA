class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1) return new int[]{0};
        Stack<int[]> stack = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        res[len - 1] = 0;
        stack.push(new int[]{temperatures[len - 1], len - 1});
        for(int i = len - 2; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) stack.pop();
            if(stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek()[1] - i;
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
