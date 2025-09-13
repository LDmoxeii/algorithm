package com.only4.algorithm.version4j.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhenyu.jiang
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 第一次遍历：找出所有包含0的行和列
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    zeroRows.add(row);
                    zeroCols.add(col);
                }
            }
        }

        // 第二次遍历：将对应行和列的元素置为0
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (zeroRows.contains(row) || zeroCols.contains(col)) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}
