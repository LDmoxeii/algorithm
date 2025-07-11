package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y > -1) {
            int source = matrix[x][y];
            if (source == target) {
                return true;
            } else if (source < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
