package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 1. 从左到右遍历上边界
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // 2. 从上到下遍历右边界
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // 3. 从右到左遍历下边界（如果存在剩余行）
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // 4. 从下到上遍历左边界（如果存在剩余列）
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }
}
