// https://leetcode.com/problems/distant-barcodes/
class Pair {
    int key;
    int val;

    Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes.length == 1) return barcodes;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[barcodes.length];
        for(int i: barcodes) map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.val, p1.val));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        int index = 0;
                while (!pq.isEmpty()) {
            Pair currMax = pq.poll();

            // place first element
            res[index++] = currMax.key;
            currMax.val--;

            if (pq.isEmpty()) break;

            Pair nextMax = pq.poll();
            res[index++] = nextMax.key;
            nextMax.val--;

            if (currMax.val != 0) pq.add(currMax);
            if (nextMax.val != 0) pq.add(nextMax);
        }
        return res;
    }
}