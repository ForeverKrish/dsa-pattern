package leetcode.string_array;

public class BestTimeStockI {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, profit = 0;
        for (int p : prices) {
            if (p < minPrice) minPrice = p;
            else profit = Math.max(profit, p - minPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeStockI sol = new BestTimeStockI();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(sol.maxProfit(new int[]{7,6,4,3,1}));
    }
}

/*
Time: O(n)
Space: O(1)
 */