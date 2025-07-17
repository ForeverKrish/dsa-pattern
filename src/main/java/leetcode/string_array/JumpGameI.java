package leetcode.string_array;

public class JumpGameI {
    //Greedy Solution
    public boolean canJump(int[] nums) {
        int finalDestinationIndex = nums.length - 1; //current destination to reach is last index
        int currentIndex = nums.length - 2; //start from secondlast element

        while (currentIndex >= 0){

            //check if from the current index you can reach the final destination
            int jumpsAtCurrentPosition = nums[currentIndex];
            if( (currentIndex + jumpsAtCurrentPosition)  >= finalDestinationIndex){
                //means you can reach the last index from this point so update the destination to current index
                finalDestinationIndex = currentIndex;
            }

            //move back a step to iterate and check again
            currentIndex --;
        }

        //check if finaldestination have moved to initial index 0, then we can jump
        return finalDestinationIndex == 0;
    }

    public boolean canJumpMinimal(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reach) return false;
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGameI sol = new JumpGameI();
        System.out.println(sol.canJump(new int[]{2,3,1,1,4}));
        System.out.println(sol.canJump(new int[]{3,2,1,0,4}));

        System.out.println(sol.canJumpMinimal(new int[]{2,3,1,1,4}));
        System.out.println(sol.canJumpMinimal(new int[]{3,2,1,0,4}));
    }
}

/*
Time: O(n)
Space: O(1)
* */