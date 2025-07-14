package leetcode.string_array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                nums[write++] = nums[read];
            }
        }
        return write;
    }

    public static void main(String[] args) {
        RemoveDuplicates sol = new RemoveDuplicates();
        int[] arr = {1,1,2};
        int len = sol.removeDuplicates(arr);
        System.out.println("Len: " + len + ", " + 
            java.util.Arrays.toString(java.util.Arrays.copyOf(arr, len)));
        int[] arr2 = {0,0,1,1,1,2,2,3,3,4};
        len = sol.removeDuplicates(arr2);
        System.out.println("Len: " + len + ", " + 
            java.util.Arrays.toString(java.util.Arrays.copyOf(arr2, len)));
    }
}
/*
Time: O(n)
Space: O(1)
 */