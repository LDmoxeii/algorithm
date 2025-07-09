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
        int m = matrix.length;
        int n = matrix[0].length;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (matrix[x][y] == 0) {
                    zeroRows.add(x);
                    zeroCols.add(y);
                }
            }
        }

        for (int x : zeroRows) {
            int delta = 0;
            while (delta < n) matrix[x][delta++] = 0;
        }

        for (int y : zeroCols) {
            int delta = 0;
            while (delta < m) matrix[delta++][y] = 0;
        }
    }
}
