package leetcode.two_pointer;

public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }
    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public static void main(String[] args) {
        SortColors sol = new SortColors();
        int[] arr1 = {2,0,2,1,1,0};
        sol.sortColors(arr1);
        System.out.println(java.util.Arrays.toString(arr1));
        // Expect [0,0,1,1,2,2]
        int[] arr2 = {2,0,1};
        sol.sortColors(arr2);
        System.out.println(java.util.Arrays.toString(arr2));
        // Expect [0,1,2]
    }
}