/**
 * [994. 腐烂的橘子](https://leetcode.com/problems/rotting-oranges/)
 *
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * - 值 0 代表空单元格；
 * - 值 1 代表新鲜橘子；
 * - 值 2 代表腐烂的橘子。
 *
 * 每分钟，腐烂的橘子会使上、下、左、右四个方向相邻的新鲜橘子腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，则返回 -1。
 *
 * 解题思路：
 * 使用广度优先搜索(BFS)来模拟腐烂过程。首先遍历整个网格，找出所有腐烂的橘子和新鲜橘子的数量。
 * 将所有腐烂的橘子加入队列作为BFS的起始点，然后逐层扩展，每一层代表一分钟。
 * 在每次扩展时，将当前腐烂橘子的四个相邻位置的新鲜橘子标记为腐烂，并加入队列。
 * 当队列为空时，检查是否还有新鲜橘子。如果有，则返回-1；否则返回经过的分钟数。
 *
 * 时间复杂度：O(m*n)，其中m和n分别是网格的行数和列数，需要遍历整个网格
 * 空间复杂度：O(m*n)，在最坏情况下，所有橘子都是腐烂的，队列的大小为m*n
 */
package com.only4.algorithm.leetcode

/**
 * 计算所有橘子腐烂所需的最小分钟数
 *
 * @param grid 表示橘子状态的二维网格，0表示空单元格，1表示新鲜橘子，2表示腐烂的橘子
 * @return 所有橘子腐烂所需的最小分钟数，如果不可能则返回-1
 */
fun orangesRotting(grid: Array<IntArray>): Int {
    // 如果网格为空，直接返回0
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    // 定义四个方向：上、下、左、右
    val directions = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

    // 用于BFS的队列，存储腐烂橘子的坐标
    val rottenQueue = ArrayDeque<Pair<Int, Int>>()

    // 统计新鲜橘子的数量
    var freshCount = 0

    // 遍历网格，找出所有腐烂的橘子和新鲜橘子
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            when (grid[i][j]) {
                1 -> freshCount++
                2 -> rottenQueue.add(Pair(i, j))
            }
        }
    }

    // 如果没有新鲜橘子，直接返回0
    if (freshCount == 0) return 0

    // 记录经过的分钟数
    var minutes = 0

    // BFS过程
    while (rottenQueue.isNotEmpty() && freshCount > 0) {
        // 每一轮代表一分钟
        minutes++

        // 处理当前队列中的所有腐烂橘子
        repeat(rottenQueue.size) {
            val (x, y) = rottenQueue.removeFirst()

            // 检查四个方向的相邻单元格
            for ((dx, dy) in directions) {
                val newX = x + dx
                val newY = y + dy

                // 检查新坐标是否在网格内且是新鲜橘子
                if (newX in grid.indices && newY in grid[newX].indices && grid[newX][newY] == 1) {
                    // 将新鲜橘子标记为腐烂
                    grid[newX][newY] = 2
                    // 新鲜橘子数量减1
                    freshCount--
                    // 将新腐烂的橘子加入队列
                    rottenQueue.add(Pair(newX, newY))
                }
            }
        }
    }

    // 如果还有新鲜橘子，说明无法全部腐烂，返回-1
    return if (freshCount == 0) minutes else -1
}

/**
 * 示例用例：
 *
 * 示例 1:
 * 输入：grid = [
 *   [2,1,1],
 *   [1,1,0],
 *   [0,1,1]
 * ]
 * 输出：4
 * 解释：
 * 第 0 分钟：初始状态
 * 第 1 分钟：(0,0)处的腐烂橘子使相邻的(0,1)和(1,0)处的橘子腐烂
 * 第 2 分钟：(0,1)处的腐烂橘子使相邻的(0,2)处的橘子腐烂，(1,0)处的腐烂橘子使相邻的(1,1)处的橘子腐烂
 * 第 3 分钟：(1,1)处的腐烂橘子使相邻的(2,1)处的橘子腐烂
 * 第 4 分钟：(2,1)处的腐烂橘子使相邻的(2,2)处的橘子腐烂
 * 所有橘子都腐烂了，共需4分钟
 *
 * 示例 2:
 * 输入：grid = [
 *   [2,1,1],
 *   [0,1,1],
 *   [1,0,1]
 * ]
 * 输出：-1
 * 解释：左下角的橘子无法被腐烂，因为它与任何腐烂的橘子都不相邻
 *
 * 示例 3:
 * 输入：grid = [
 *   [0,2]
 * ]
 * 输出：0
 * 解释：初始状态下没有新鲜橘子，所以返回0
 */

