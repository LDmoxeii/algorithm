package com.only4.algorithm.version4j.leetcode;

public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 从右上角开始搜索
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int currentValue = matrix[row][col];

            if (currentValue == target) {
                return true;
            } else if (currentValue > target) {
                col--; // 当前值太大，向左移动
            } else {
                row++; // 当前值太小，向下移动
            }
        }

        return false;
    }
}
