package leetcode.string_array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] a, int l, int r) {
        while (l < r) {
            int t = a[l]; a[l++] = a[r]; a[r--] = t;
        }
    }

    public static void main(String[] args) {
        RotateArray sol = new RotateArray();
        int[] arr = {1,2,3,4,5,6,7};
        sol.rotate(arr, 3);
        System.out.println(java.util.Arrays.toString(arr));
        int[] arr2 = {-1,-100,3,99};
        sol.rotate(arr2, 2);
        System.out.println(java.util.Arrays.toString(arr2));
    }
}