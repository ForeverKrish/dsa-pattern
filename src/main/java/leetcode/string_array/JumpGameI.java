package leetcode.string_array;

public class JumpGameI {
    public boolean canJump(int[] nums) {
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
    }
}

/*
Time: O(n)
Space: O(1)
* */