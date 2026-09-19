class Solution {
    public int maxProfit(int[] prices) {
        // 7,1,5,3,6,4
        
        int maxProfit = 0; // 5
        int min = prices[0]; // 1
        
        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);   
        }
        
        return maxProfit;
    }
}