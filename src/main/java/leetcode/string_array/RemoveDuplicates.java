package leetcode.string_array;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int readIndex = 0, writeIndex = 0;

        while(readIndex < nums.length){
            if(readIndex < 1){
                writeIndex++;
            }
            if(nums[readIndex] != nums[writeIndex-1]){ //IMP: use writeIndex instead of read to tackle inplace overwrites OR use single pointer to write and foreach to read
                nums[writeIndex++] = nums[readIndex];
            }
            readIndex++;
        }
        return writeIndex;
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