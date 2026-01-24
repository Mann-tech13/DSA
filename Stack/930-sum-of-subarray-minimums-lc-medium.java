class Solution {
    public int[] nextSmallElementIndex(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()) res[i] = arr.length;
            else res[i] = st.peek();
            st.push(i);
        }
        return res;
    }
    public int[] prevSmallElementIndex(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            if(st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();
            st.push(i);
        }
        return res;
    }
    public int sumSubarrayMins(int[] A) {
        int n = A.length;
        int mod = 1_000_000_007;

        int[] nseIndex = nextSmallElementIndex(A);
        int[] pseIndex = prevSmallElementIndex(A);
        long total = 0;

        for(int i = 0; i < A.length; i++) {
            long left = i - pseIndex[i];
            long right = nseIndex[i] - i;

            total = (total + left * right * A[i]) % mod;
        }

        return (int)total;
    }
}
