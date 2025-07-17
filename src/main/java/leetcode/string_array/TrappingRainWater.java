package leetcode.string_array;

public class TrappingRainWater {

    public int trap(int[] height) {
        //explanation: https://www.youtube.com/watch?v=1_5VuquLbXg

        int leftMaxHeight = 0, rightMaxHeight = 0;
        int left = 0, right = height.length - 1;
        int trappedWater = 0;

        //travese using 2 pointer and at each pont check which is small left/right and move the pointers inward
        while(left < right){

            //operate on the lower height
            if(height[left] <= height[right]){
                leftMaxHeight = Math.max(leftMaxHeight, height[left]);

                //add the volume which is (leftMaxHeight - height of the tower ) * 1 and move left
                trappedWater += (leftMaxHeight) - height[left];
                left++;
            }else{
                rightMaxHeight = Math.max(rightMaxHeight, height[right]);

                //add the volume which is (rightMaxHeight - height of the tower ) * 1 and move right
                trappedWater += (rightMaxHeight) - height[right];
                right--;
            }

        }
        return trappedWater;
    }

    public int trapMinimal(int[] height) {
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

        System.out.println(sol.trapMinimal(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(sol.trapMinimal(new int[]{4,2,0,3,2,5}));
    }
}
/*
Time: O(n)
Space: O(1)
 */