package leetcode.string_array;

public class BestTimeStockII {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }

        int maxProfit = 0,currentDayIndex = 1;
        int previousDayPrice = prices[0];
        int currentDayPrice = 0;

        while(currentDayIndex < prices.length){
            //sell at local maxima
            currentDayPrice = prices[currentDayIndex];
            if(previousDayPrice < currentDayPrice){
                //sell at local maxima
                maxProfit = maxProfit +  currentDayPrice - previousDayPrice;
            }
            //buy at local minima - do nothing in code

            previousDayPrice = currentDayPrice;
            currentDayIndex++;
        }

        return maxProfit;
    }

    public int maxProfitMinimal(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeStockII sol = new BestTimeStockII();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(sol.maxProfit(new int[]{1,2,3,4,5}));

        System.out.println(sol.maxProfitMinimal(new int[]{7,1,5,3,6,4}));
        System.out.println(sol.maxProfitMinimal(new int[]{1,2,3,4,5}));
    }
}
/*
Time: O(n)
Space: O(1)
* */