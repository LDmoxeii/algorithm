/**
 * [200. 岛屿数量](https://leetcode.com/problems/number-of-islands/)
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 解题思路：
 * 使用深度优先搜索（DFS）遍历整个网格。当找到一个陆地（'1'）时，通过DFS将与之相连的所有陆地都标记为已访问（修改为'0'），
 * 这样就将整个岛屿都标记完成，岛屿数量加1。继续遍历网格，重复上述过程，直到遍历完整个网格。
 *
 * 时间复杂度：O(m*n)，其中m和n分别为网格的行数和列数，需要遍历整个网格
 * 空间复杂度：O(m*n)，在最坏情况下，整个网格都是陆地，DFS的深度为m*n
 */
package com.only4.algorithm.leetcode

/**
 * 计算岛屿数量
 *
 * @param grid 由'1'（陆地）和'0'（水）组成的二维网格
 * @return 岛屿的数量
 */
fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val rows = grid.size
    val cols = grid[0].size
    val directions = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
    var count = 0

    fun isValid(x: Int, y: Int) = x in 0 until rows && y in 0 until cols

    fun dfs(x: Int, y: Int) {
        if (!isValid(x, y) || grid[x][y] != '1') return

        // 标记当前陆地为已访问
        grid[x][y] = '0'

        // 探索四个方向
        directions.forEach { (dx, dy) ->
            dfs(x + dx, y + dy)
        }
    }

    // 遍历整个网格
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (grid[i][j] == '1') {
                count++
                dfs(i, j)
            }
        }
    }

    return count
}

/**
 * 示例用例：
 *
 * 示例 1:
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 解释：这是一个完整的岛屿，所有的 '1' 都相连。
 *
 * 示例 2:
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 * 解释：左上角、右下角和中间各有一个岛屿。
 *
 * 示例 3:
 * 输入：grid = [
 *   ["1","0","1","0","1"],
 *   ["0","1","0","1","0"],
 *   ["1","0","1","0","1"],
 *   ["0","1","0","1","0"]
 * ]
 * 输出：10
 * 解释：每个 '1' 都是一个独立的岛屿，因为它们之间没有水平或垂直连接。
 */
