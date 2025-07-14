package leetcode.two_pointer;

import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        ThreeSumClosest sol = new ThreeSumClosest();
        System.out.println(sol.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        // Expect 2 (-1+2+1=2)
        System.out.println(sol.threeSumClosest(new int[]{0,0,0}, 1));
        // Expect 0
    }
}