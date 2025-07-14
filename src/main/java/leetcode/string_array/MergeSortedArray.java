package leetcode.string_array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, // pointer for nums1’s last valid element
                p2 = n - 1, // pointer for nums2’s last element
                p = m + n - 1; // pointer for write position in nums1
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
    }

    // Test cases
    public static void main(String[] args) {
        MergeSortedArray sol = new MergeSortedArray();
        int[] a1 = {1,2,3,0,0,0}, b1 = {2,5,6};
        sol.merge(a1, 3, b1, 3);
        System.out.println("Merged: " + java.util.Arrays.toString(a1));
        int[] a2 = {0}, b2 = {1};
        sol.merge(a2, 0, b2, 1);
        System.out.println("Merged: " + java.util.Arrays.toString(a2));
    }
}

/*
Time: O(m + n)
Space: O(1)
 */