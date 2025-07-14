package leetcode.stringarray;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int write = 0;

        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != val) {
                nums[write++] = nums[read];
            }
        }
        return write;
    }

    public static void main(String[] args) {
        RemoveElement sol = new RemoveElement();
        int[] arr = {3,2,2,3};
        int newLen = sol.removeElement(arr, 3);
        System.out.println("Length: " + newLen + ", " + 
            java.util.Arrays.toString(java.util.Arrays.copyOf(arr, newLen)));
        int[] arr2 = {0,1,2,2,3,0,4,2};
        newLen = sol.removeElement(arr2, 2);
        System.out.println("Length: " + newLen + ", " + 
            java.util.Arrays.toString(java.util.Arrays.copyOf(arr2, newLen)));
    }
}
/*
Time: O(n)

Space: O(1)
 */