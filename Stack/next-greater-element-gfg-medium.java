// https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            res.add(0);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            res.set(i, st.isEmpty() ? -1 : st.peek());
            st.push(arr[i]);
        }
        return res;
    }
}