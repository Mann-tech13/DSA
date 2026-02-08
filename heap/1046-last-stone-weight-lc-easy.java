// https://leetcode.com/problems/last-stone-weight/

class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: stones) {
            pq.offer(num);
        }
        while(!pq.isEmpty() && pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if(x != y) pq.offer(y - x);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}