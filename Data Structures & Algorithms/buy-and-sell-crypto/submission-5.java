class Solution {
    public int maxProfit(int[] prices) {
        int buy=0;
        int sell=buy+1;
        int profit=0;
        while(buy<sell && sell<prices.length){
            if(prices[buy]<=prices[sell]){
                profit= Math.max(profit,prices[sell]-prices[buy]);
                sell++;
            }else{
                buy=sell; sell++;
            }
        }
        return profit;
    }
}
