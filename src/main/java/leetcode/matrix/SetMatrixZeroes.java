package leetcode.matrix;

import java.util.*;

public class SetMatrixZeroes {
    public void setZeroes(int[][] a) {
        int m = a.length, n = a[0].length;
        boolean firstColZero = false;
        for (int i = 0; i < m; i++) {
            if (a[i][0] == 0) firstColZero = true;
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 0) {
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (a[i][0] == 0 || a[0][j] == 0) {
                    a[i][j] = 0;
                }
            }
            if (firstColZero) {
                a[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes sol = new SetMatrixZeroes();
        int[][] m = {{1,1,1},{1,0,1},{1,1,1}};
        sol.setZeroes(m);
        System.out.println(Arrays.deepToString(m)); // Expect [[1,0,1],[0,0,0],[1,0,1]]
    }
}