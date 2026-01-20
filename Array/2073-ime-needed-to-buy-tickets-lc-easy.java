// https://leetcode.com/problems/time-needed-to-buy-tickets/
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        int n = tickets.length;

        for(int i=0;i<n;i++){
            if(i==k) ans+=tickets[i];
            else if(i<k){
                ans+=Math.min(tickets[i], tickets[k]);
            }
            else{
                ans+=Math.min(tickets[i], tickets[k]-1);
            }
        }

        return ans;
    }
}