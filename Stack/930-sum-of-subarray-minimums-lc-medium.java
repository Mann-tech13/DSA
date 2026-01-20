// https://leetcode.com/problems/sum-of-subarray-minimums/
class Solution {
    public int sumSubarrayMins(int[] A) {
        int n = A.length;
        int MOD = 1_000_000_007;

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = i + 1;
            right[i] = n - i;
        }

        // Stacks storing {value, index}
        Deque<int[]> prevLess = new ArrayDeque<>();
        Deque<int[]> nextLess = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Previous Less Element
            while (!prevLess.isEmpty() && prevLess.peek()[0] > A[i]) {
                prevLess.pop();
            }
            left[i] = prevLess.isEmpty() ? i + 1 : i - prevLess.peek()[1];
            prevLess.push(new int[]{A[i], i});

            // Next Less Element
            while (!nextLess.isEmpty() && nextLess.peek()[0] > A[i]) {
                int[] top = nextLess.pop();
                right[top[1]] = i - top[1];
            }
            nextLess.push(new int[]{A[i], i});
        }

        // Calculate result
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long contribution = (long) A[i] * left[i] * right[i];
            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }
}
