package leetcode.string_array;

public class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, leftMax = 0, rightMax = 0, water = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                leftMax = Math.max(leftMax, height[l]);
                water += leftMax - height[l++];
            } else {
                rightMax = Math.max(rightMax, height[r]);
                water += rightMax - height[r--];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater sol = new TrappingRainWater();
        System.out.println(sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(sol.trap(new int[]{4,2,0,3,2,5}));
    }
}
/*
Time: O(n)
Space: O(1)
 */