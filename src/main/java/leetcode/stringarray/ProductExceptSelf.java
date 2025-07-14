package leetcode.stringarray;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= suffix;
            suffix *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        ProductExceptSelf sol = new ProductExceptSelf();
        System.out.println(java.util.Arrays.toString(sol.productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(java.util.Arrays.toString(sol.productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

    /**
     * Time: O(n)
     * Space: O(1) extra (output not counted)
     */
}