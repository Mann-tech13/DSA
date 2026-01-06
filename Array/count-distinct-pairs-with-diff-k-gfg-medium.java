// https://www.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1
class Solution {
    public int TotalPairs(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int count = 0 ;
        for(int num : map.keySet()) {
            if(k > 0 && map.containsKey(num + k)) {
                count++;
            }
            else if(k == 0 && map.get(num) > 1) {
                count++;
            }
        }
        return count;
    }
}

