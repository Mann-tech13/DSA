// https://leetcode.com/problems/non-overlapping-intervals/description/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1,i2)->Integer.compare(i1[0],i2[0]));
        int ans = 0;
        int prevEnd = intervals[0][1];
        
        
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= prevEnd){
                prevEnd = intervals[i][1];
            }
            else{
                ans++;
                prevEnd = Math.min(intervals[i][1], prevEnd);
            }
        }
        
        return ans;
    }
}
