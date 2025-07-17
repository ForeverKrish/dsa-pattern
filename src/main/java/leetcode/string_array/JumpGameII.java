package leetcode.string_array;

//Greedy Approach
public class JumpGameII {
    public int jump(int[] nums) {
        int currIndex = 0;
        int nodeFromWhereNextMaxDestinationCanBeAchived = 0;
        int maxDestinationToBeReached = 0;
        int minJumpsRequired = 0;

        while(currIndex < nums.length){
            int currentMaxRangeOfJump = nums[currIndex];

            //check how far can you jump and store the farthest for each window
            maxDestinationToBeReached = Math.max(maxDestinationToBeReached, (currentMaxRangeOfJump + currIndex));

            //if currentIndex has reached the maxDestinationToBeReached -> make the jump
            if(currIndex == nodeFromWhereNextMaxDestinationCanBeAchived){
                //jump is made to this node and nest maxDestination is updated as where the next jump should take us
                nodeFromWhereNextMaxDestinationCanBeAchived = maxDestinationToBeReached;
                if(currIndex != 0){
                    //first node is not considered as jump
                    minJumpsRequired++;
                }
            }

            //determine you are able to reach the end of array or not -> this conditions saves few more loops but without this also the answer will not vary
            if(maxDestinationToBeReached >= nums.length -1){
                //if yes make the jump and return the count+1
                return minJumpsRequired;
            }

            //check all elements range
            currIndex++;
        }

        //determine you are able to reach the end of array or not
        return (maxDestinationToBeReached >= nums.length) ? minJumpsRequired : 0;
    }

    public int jumpMinimal(int[] nums) {
        int jumps = 0, currEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII sol = new JumpGameII();
        System.out.println(sol.jump(new int[]{2,3,1,1,4}));
        System.out.println(sol.jump(new int[]{2,3,0,1,4}));
        System.out.println(sol.jump(new int[]{2,4,1,2,3,1,1,2}));

        System.out.println(sol.jumpMinimal(new int[]{2,3,1,1,4}));
        System.out.println(sol.jumpMinimal(new int[]{2,3,0,1,4}));
        System.out.println(sol.jumpMinimal(new int[]{2,4,1,2,3,1,1,2}));
    }

    /*
    Time: O(n)
    Space: O(1)
    * */
}