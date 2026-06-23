class Solution {
    public int maxProfit(int[] prices) {
        int buyDay = 0;
        int prevBuy =0;
        int prevSell=0;
        int sellDay = 1;
        int maxProfit = 0;

        while(buyDay<prices.length && sellDay<prices.length){

            if(prices[buyDay]<=prices[sellDay]){
            maxProfit = Math.max(maxProfit,prices[sellDay]-prices[buyDay]);
            prevBuy = prices[buyDay];prevSell = prices[sellDay];
            sellDay++;
            }else if(prices[sellDay]<prices[buyDay]){
                buyDay = sellDay;
                sellDay = sellDay+1;
            }
            else{
                buyDay++; sellDay++;
            }
        }
        return maxProfit;
    }
}
