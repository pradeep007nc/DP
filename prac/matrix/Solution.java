package prac.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1}};
        new Solution().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    list.add(new int[]{i, j});
            }
        }

        for (int[] data : list) {
            setZero(matrix, data[0], data[1]);
        }
    }

    public void setZero(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;  // Corrected index from row to col
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;  // Corrected index from col to row
        }
    }
}
