package leetcode.sliding_window;

public class MinSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, currWindowSum  = 0, minimumLengthWindow = Integer.MAX_VALUE;
        while( end < nums.length){
            currWindowSum = currWindowSum + nums[end];

             if(currWindowSum > target && start <= end){
                 while (currWindowSum > target){
                     currWindowSum = currWindowSum - nums[start];
                     start ++;
                 }
             }

             if(currWindowSum == target){
                 minimumLengthWindow = Math.min(minimumLengthWindow,end - start + 1);
             }

            end++;
        }
        return (minimumLengthWindow == Integer.MAX_VALUE) ? 0 : minimumLengthWindow;
    }

    public int minSubArrayLenMinimal(int target, int[] nums) {
        int sum = 0, minLen = Integer.MAX_VALUE, start = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start++];
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        MinSubarraySum sol = new MinSubarraySum();
        System.out.println(sol.minSubArrayLen(7, new int[]{2,3,1,2,4,3})); // Expect 2
        System.out.println(sol.minSubArrayLen(4, new int[]{1,4,4}));       // Expect 1
        System.out.println(sol.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1})); // Expect 0
    }
}