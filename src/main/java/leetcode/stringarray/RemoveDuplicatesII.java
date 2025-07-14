package leetcode.stringarray;

public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        int index = 0;
        while (index < nums.length){
            if(index < 2 || nums[index] != nums[index -2]){
                nums[++write] = nums[index];
            }
            index++;
        }
        /*OPTION 2
        while (int index)
        for (int num : nums) {
            if (write < 2 || num != nums[write - 2]) {
                nums[write++] = num;
            }
        }*/
        return write;
    }

    public static void main(String[] args) {
        RemoveDuplicatesII sol = new RemoveDuplicatesII();
        int[] arr = {1,1,1,2,2,3};
        int len = sol.removeDuplicates(arr);
        System.out.println("Len: " + len + ", " +
            java.util.Arrays.toString(java.util.Arrays.copyOf(arr, len)));
        int[] arr2 = {0,0,1,1,1,1,2,3,3};
        len = sol.removeDuplicates(arr2);
        System.out.println("Len: " + len + ", " +
            java.util.Arrays.toString(java.util.Arrays.copyOf(arr2, len)));
    }
}