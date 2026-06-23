class Solution {
    public int maxProfit(int[] prices) {
        int profit =0;
        int curr =0; int next=1;
        while(curr<next && next<prices.length){
            if(prices[curr]<=prices[next]){
                profit = Math.max(profit,prices[next]-prices[curr]);
                next++;
            }else{
                curr++;
                next = curr +1;
            }
        }

        return profit;
    }
}
