package leetcode.string_array;

public class RemoveElement {
    public int removeElementAndReplaceWithNegetive(int[] nums, int val) {
        int readIndex = 0, writeIndex = 0;
        while(readIndex < nums.length){
            if(nums[readIndex] != val){
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        int udpatedLength = writeIndex;

        //filling with -1 for remaining
        while(writeIndex < nums.length){
            nums[writeIndex++] = -1;
        }
        return writeIndex;
    }

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

        int[] arr_1 = {3,2,2,3};
        int newLen2 = sol.removeElementAndReplaceWithNegetive(arr_1, 3);
        System.out.println("Length: " + newLen + ", " +
                java.util.Arrays.toString(java.util.Arrays.copyOf(arr_1, newLen2)));


        int[] arr2 = {0,1,2,2,3,0,4,2};
        newLen = sol.removeElement(arr2, 2);
        System.out.println("Length: " + newLen + ", " +
            java.util.Arrays.toString(java.util.Arrays.copyOf(arr2, newLen)));

        int[] arr2_1 = {0,1,2,2,3,0,4,2};
        newLen2 = sol.removeElementAndReplaceWithNegetive(arr2_1, 2);
        System.out.println("Length: " + newLen + ", " +
                java.util.Arrays.toString(java.util.Arrays.copyOf(arr2_1, newLen2)));
    }
}
/*
Time: O(n)

Space: O(1)
 */