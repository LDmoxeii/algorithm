package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int current = matrix[row][col];
            if (current == target) {
                return true;
            } else if (current > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
