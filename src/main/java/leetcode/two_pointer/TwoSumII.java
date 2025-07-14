package leetcode.two_pointer;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                return new int[]{ lo + 1, hi + 1 };
            } else if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSumII sol = new TwoSumII();
        int[] res1 = sol.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println("Indices: " + java.util.Arrays.toString(res1)); // Expect [1,2]
        int[] res2 = sol.twoSum(new int[]{2,3,4}, 6);
        System.out.println("Indices: " + java.util.Arrays.toString(res2)); // Expect [1,3]
    }
}
/*
Time Complexity: O(n) — each pointer moves at most n steps
Space Complexity: O(1)
*/