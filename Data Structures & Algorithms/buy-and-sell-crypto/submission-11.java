class Solution {
    public int maxProfit(int[] prices) {
                int buy = 0;
        int maxProfit = 0;

        int sell = 1;
        while(buy<sell && sell<prices.length){
            if(prices[buy]<prices[sell]){
                int profit = prices[sell]-prices[buy];
                maxProfit = Math.max(maxProfit,profit);
            }else{
                buy = sell;
            }
            sell++;
        }

        return maxProfit;
    }
}