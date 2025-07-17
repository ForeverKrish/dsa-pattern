package leetcode.string_array;

import java.util.Arrays;

public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
       int writeIndex = 0, readIndex = 0;
       while(readIndex < nums.length){

           //System.out.println("readIndex: "+readIndex+" value: "+nums[readIndex] + " | writeIndex "+writeIndex+" value:"+nums[writeIndex] + " "+ Arrays.toString(nums));
           if(readIndex < 2){
               writeIndex++;
           }else if(nums[readIndex] != nums[writeIndex - 2]){ //IMP: use writeIndex instead of read to tackle inplace overwrites OR use single pointer to write and foreach to read
               nums[writeIndex++] = nums[readIndex];
           }
           readIndex++;

       }
       return writeIndex;
    }

    public int removeDuplicatesM(int[] nums) {
        int write = 0;
        for (int num : nums) {
            System.out.println("num: "+num+ " | writeIndex "+write+" value:"+nums[write] + " "+ Arrays.toString(nums));
            if (write < 2 || num != nums[write - 2]) {
                nums[write++] = num;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        RemoveDuplicatesII sol = new RemoveDuplicatesII();
        int[] arr = {1,2,2,2,3};
        int len = sol.removeDuplicates(arr);
        System.out.println("Len: " + len + ", " +
            java.util.Arrays.toString(java.util.Arrays.copyOf(arr, len)));
        int[] arr2 = {0,0,1,1,1,1,1,1,1,1,2,2,2,2,2,3,4,5,5,5,5,5,5};
        len = sol.removeDuplicates(arr2);
        System.out.println("Len: " + len + ", " +
            java.util.Arrays.toString(java.util.Arrays.copyOf(arr2, len)));
    }
}