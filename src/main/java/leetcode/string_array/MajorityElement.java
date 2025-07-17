package leetcode.string_array;

public class MajorityElement {
    // Boyer–Moore Voting
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; // Or throw an exception for an empty array
        }

        // Phase 1: Finding a candidate {3,2,3,1,3,2,3}
        int candidate = 0; // The potential majority element
        int count = 0;     // The count of the candidate

        for (int num : nums) {
            if (count == 0) { // If the current count is 0, update the candidate to the current element
                candidate = num;
                count = 1;
            } else if (num == candidate) { // If the current element is the same as the candidate, increment count
                count++;
            } else { // If the current element is different from the candidate, decrement count
                count--;
            }
        }
        System.out.println("Proposed candidate: "+candidate);
        // Phase 2: Verification (Optional, but recommended if majority element isn't guaranteed)
        count = 0; // Reset count for the verification phase
        for (int num : nums) {
            if (num == candidate) { // Count the occurrences of the candidate in the array
                count++;
            }
        }

        if (count > nums.length / 2) { // If the count is greater than n/2, the candidate is the majority element
            return candidate;
        } else {
            return -1; // No majority element found
        }
    }

    public static void main(String[] args) {
        MajorityElement sol = new MajorityElement();
        System.out.println(sol.majorityElement(new int[]{3,2,3}));
        System.out.println(sol.majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(sol.majorityElement(new int[]{3,2,2,3,2,3,2,3,2,2}));

    }

    /*
    Time: O(2n) = O(n)
    Space: O(1)
     */
}