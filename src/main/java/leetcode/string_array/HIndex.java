package leetcode.string_array;

import java.util.Arrays;
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex sol = new HIndex();
        System.out.println(sol.hIndex(new int[]{3,0,6,1,5}));
        System.out.println(sol.hIndex(new int[]{1,3,1}));
    }
}