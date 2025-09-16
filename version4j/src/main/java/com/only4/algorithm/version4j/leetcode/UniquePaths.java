package com.only4.algorithm.version4j.leetcode;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // dp[row][col] 表示到达位置(row, col)的不同路径数
        int[][] pathCountToPosition = new int[m][n];

        // 初始化第一列，从起点到第一列任意位置只有一种路径（一直向下）
        for (int rowIndex = 0; rowIndex < m; rowIndex++) {
            pathCountToPosition[rowIndex][0] = 1;
        }

        // 初始化第一行，从起点到第一行任意位置只有一种路径（一直向右）
        for (int colIndex = 0; colIndex < n; colIndex++) {
            pathCountToPosition[0][colIndex] = 1;
        }

        // 计算其他位置的路径数：路径数 = 上方路径数 + 左方路径数
        for (int rowIndex = 1; rowIndex < m; rowIndex++) {
            for (int colIndex = 1; colIndex < n; colIndex++) {
                int pathsFromAbove = pathCountToPosition[rowIndex - 1][colIndex];
                int pathsFromLeft = pathCountToPosition[rowIndex][colIndex - 1];
                pathCountToPosition[rowIndex][colIndex] = pathsFromAbove + pathsFromLeft;
            }
        }

        // 返回到达右下角的路径总数
        return pathCountToPosition[m - 1][n - 1];
    }
}
