// https://leetcode.com/problems/asteroid-collision/
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];

            while (!st.isEmpty() && st.peek() > 0 && curr < 0) {
                int top = st.peek();

                if (Math.abs(top) < Math.abs(curr)) {
                    st.pop();
                    continue;
                } 
                else if (Math.abs(top) == Math.abs(curr)) {
                    st.pop();
                    curr = 0;
                    break;
                } 
                else {
                    curr = 0;
                    break;
                }
            }

            if (curr != 0) {
                st.push(curr);
            }
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
