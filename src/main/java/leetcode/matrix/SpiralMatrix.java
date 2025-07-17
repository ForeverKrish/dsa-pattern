package leetcode.matrix;

import java.util.*;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) res.add(matrix[top][c]);
            top++;
            for (int r = top; r <= bottom; r++) res.add(matrix[r][right]);
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) res.add(matrix[bottom][c]);
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) res.add(matrix[r][left]);
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix sol = new SpiralMatrix();
        int[][] m1 = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println(sol.spiralOrder(m1)); // Expect [1,2,3,6,9,8,7,4,5]

        int[][] m2 = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        System.out.println(sol.spiralOrder(m2)); // Expect [1,2,3,4,8,12,11,10,9,5,6,7]
    }
}