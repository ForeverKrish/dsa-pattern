package leetcode.string_array;

public class BestTimeStockII {
    public int maxProfit(int[] prices) {
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
    }
}
/*
Time: O(n)
Space: O(1)
* */