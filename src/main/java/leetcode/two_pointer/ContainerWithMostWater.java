package leetcode.two_pointer;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1, max = 0;
        while (lo < hi) {
            int area = (hi - lo) * Math.min(height[lo], height[hi]);
            max = Math.max(max, area);
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();
        System.out.println(sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        // Expect 49
        System.out.println(sol.maxArea(new int[]{1,1}));
        // Expect 1
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
* */