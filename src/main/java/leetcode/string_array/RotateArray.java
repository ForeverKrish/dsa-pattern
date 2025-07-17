package leetcode.string_array;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k){
        int l = nums.length;
        k %= l; //for cases where length < k

        //reverse full:
        reverse(nums,0,l-1);

        //reverse 0:k
        reverse(nums,0,k-1);

        //reverse remaining
        reverse(nums,k,l-1);
    }
    private void reverse(int[] nums, int start, int end){

        while(start<end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        RotateArray sol = new RotateArray();
        int[] arr = {1,2,3,4,5,6,7}; //
        sol.rotate(arr, 3);
        System.out.println(java.util.Arrays.toString(arr));
        int[] arr2 = {-1,-100,3,99};
        sol.rotate(arr2, 2);
        System.out.println(java.util.Arrays.toString(arr2));
    }
}