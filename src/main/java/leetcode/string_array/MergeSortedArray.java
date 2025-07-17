package leetcode.string_array;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //insert biggest of 2 from last
        int insertIndex = m + n -1;

        //special case 1
        if(m == 0){
            for(int i = 0; i < nums2.length ; i++){
                nums1[i] = nums2[i];
            }
        }

//        //special case 2
//        if(n == 0){
//            //Do nothing: m is already sorted
//        }

        while (m > 0 && n > 0){
            //compare the last mth element of nums1 and nth element of nums2
            //whichever is biggest insert at last position of nums1 them n+m--
            if(nums2[n-1] > nums1[m-1]){
                nums1[insertIndex] = nums2[n-1];
                n--;
            }else{
                nums1[insertIndex] = nums1[m-1];
                m--;
            }
            insertIndex--;
        }
    }
    public void mergeMinimal(int[] nums1, int m, int[] nums2, int n) {
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
        sol.mergeMinimal(a1, 3, b1, 3);
        System.out.println("Merged: " + java.util.Arrays.toString(a1));

        int[] a2 = {0}, b2 = {1};
        sol.merge(a2, 0, b2, 1);
        System.out.println("Merged: " + java.util.Arrays.toString(a2));
        sol.mergeMinimal(a2, 0, b2, 1);
        System.out.println("Merged: " + java.util.Arrays.toString(a2));

        int[] a3 = {1}, b3 = {};
        sol.merge(a3, 1, b3, 0);
        System.out.println("Merged: " + java.util.Arrays.toString(a3));
        sol.mergeMinimal(a3, 0, b2, 1);
        System.out.println("Merged: " + java.util.Arrays.toString(a3));
    }
}

/*
Time: O(m + n)
Space: O(1)
 */