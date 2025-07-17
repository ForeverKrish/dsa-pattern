package leetcode.matrix;

import java.util.*;

public class RotateImage {
    public void rotate(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                int tmp = a[i][l];
                a[i][l] = a[i][r];
                a[i][r] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage sol = new RotateImage();
        int[][] img = {{1,2,3},{4,5,6},{7,8,9}};
        sol.rotate(img);
        System.out.println(Arrays.deepToString(img)); // Expect [[7,4,1],[8,5,2],[9,6,3]]
    }
}