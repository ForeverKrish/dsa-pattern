package leetcode.string_array;

public class BestTimeStockI {

    public int maxProfit(int[] prices) {
        int minimumPrice  = Integer.MAX_VALUE, maxProfit = 0;
        for (int currentPrice: prices){
            minimumPrice = Math.min(minimumPrice,currentPrice);
            maxProfit = Math.max(maxProfit,currentPrice - minimumPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeStockI sol = new BestTimeStockI();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,8,4}));
        System.out.println(sol.maxProfit(new int[]{7,6,4,3,1}));
    }
}

/*
Time: O(n)
Space: O(1)
 */