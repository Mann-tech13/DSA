// https://leetcode.com/problems/min-stack/
class Pair {
    int key;
    int minValue;

    Pair(int key, int minValue) {
        this.key = key;
        this.minValue = minValue;
    }
}

class MinStack {
    private Stack<Pair> stack;
	
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        int min = Integer.MAX_VALUE;
        if(stack.isEmpty()) min = x;
        else min = Math.min(x, stack.peek().minValue);
        stack.push(new Pair(x, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().key;
    }
    
    public int getMin() {
        return stack.peek().minValue;
    }
}