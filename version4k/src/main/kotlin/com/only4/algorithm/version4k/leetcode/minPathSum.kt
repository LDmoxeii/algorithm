package com.only4.algorithm.version4k.leetcode

/**
 * [64. 最小路径和](https://leetcode.com/problems/minimum-path-sum/)
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 * - 输入: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * - 输出: 7
 * - 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * - 输入: grid = [[1,2,3],[4,5,6]]
 * - 输出: 12
 *
 * 解题思路:
 * 使用动态规划解决此问题。定义dp[i][j]为从左上角到位置(i,j)的最小路径和。
 * 1. 初始化：dp[0][0] = grid[0][0]
 * 2. 对于第一行，只能从左侧到达：dp[0][j] = dp[0][j-1] + grid[0][j]
 * 3. 对于第一列，只能从上方到达：dp[i][0] = dp[i-1][0] + grid[i][0]
 * 4. 对于其他位置(i,j)，可以从上方(i-1,j)或左方(i,j-1)到达，选择路径和较小的方向：
 *    dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
 * 5. 最终返回dp[m-1][n-1]，即右下角位置的最小路径和
 *
 * 时间复杂度: O(m * n)，需要填充整个dp数组
 * 空间复杂度: O(m * n)，需要一个m*n的dp数组（这里使用Map存储）
 *
 * @param grid 包含非负整数的 m x n 网格
 * @return 从左上角到右下角的最小路径和
 */
fun minPathSum(grid: Array<IntArray>): Int {
    // 使用Map存储每个位置的最小路径和，键为(row, col)坐标对
    val minPathSumMap = mutableMapOf<Pair<Int, Int>, Int>().also { pathMap ->
        // 初始化起点位置
        pathMap[0 to 0] = grid[0][0]

        // 初始化第一列，每个位置只能从上方到达
        for (row in 1 until grid.size) {
            pathMap[row to 0] = pathMap[row - 1 to 0]!! + grid[row][0]
        }

        // 初始化第一行，每个位置只能从左侧到达
        for (col in 1 until grid[0].size) {
            pathMap[0 to col] = pathMap[0 to col - 1]!! + grid[0][col]
        }
    }

    // 填充dp数组，计算每个位置的最小路径和
    for (row in 1 until grid.size) {
        for (col in 1 until grid[0].size) {
            // 当前位置的最小路径和 = min(上方位置的最小路径和, 左方位置的最小路径和) + 当前位置的值
            minPathSumMap[row to col] =
                minOf(minPathSumMap[row - 1 to col]!!, minPathSumMap[row to col - 1]!!) + grid[row][col]
        }
    }

    // 返回右下角位置的最小路径和
    return minPathSumMap[grid.lastIndex to grid[0].lastIndex]!!
}
