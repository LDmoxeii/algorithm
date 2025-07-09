package com.only4.algorithm.version4j.leetcode;

import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = matrix.length;
        if (m == 0) return List.of();
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        int x = 0, y = 0, directionIndex = 0;
        List<Integer> result = new java.util.ArrayList<>();

        for (int i = 0; i < m * n; i++) {
            result.add(matrix[x][y]);
            visited[x][y] = true;

            int nextX = x + directions[directionIndex][0];
            int nextY = y + directions[directionIndex][1];

            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
                directionIndex = (directionIndex + 1) % 4; // Change direction
                nextX = x + directions[directionIndex][0];
                nextY = y + directions[directionIndex][1];
            }

            x = nextX;
            y = nextY;
        }
        return result;
    }
}
