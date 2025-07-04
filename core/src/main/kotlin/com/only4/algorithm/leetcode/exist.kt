package com.only4.algorithm.leetcode

/**
 * [79. 单词搜索](https://leetcode.com/problems/word-search/)
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word。如果 word 存在于网格中，返回 true；否则，返回 false。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中"相邻"单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 解题思路：
 * 使用回溯算法（DFS）遍历二维网格，对于每个单元格，尝试以它为起点匹配单词：
 * 1. 如果当前字符不匹配，直接返回false
 * 2. 如果已经匹配到单词最后一个字符，返回true
 * 3. 将当前字符标记为已访问（修改为特殊字符'0'）
 * 4. 递归搜索四个方向（上、下、左、右）
 * 5. 恢复当前字符，回溯
 *
 * 时间复杂度：O(m*n*4^L)，其中m和n是网格的维度，L是单词长度
 * 空间复杂度：O(L)，递归调用栈的深度最大为L
 */
fun exist(board: Array<CharArray>, word: String): Boolean {
    // 定义四个方向：上、下、左、右
    val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    /**
     * 深度优先搜索函数
     *
     * @param x 当前行坐标
     * @param y 当前列坐标
     * @param index 当前匹配到的字符索引
     * @return 是否能从当前位置匹配剩余的单词
     */
    fun dfs(x: Int, y: Int, index: Int): Boolean {
        // 如果当前字符不匹配，返回false
        if (board[x][y] != word[index]) return false

        // 如果已经匹配到最后一个字符，返回true
        if (index == word.lastIndex) return true

        // 标记当前单元格为已访问
        val originalChar = board[x][y]
        board[x][y] = '0'

        // 尝试四个方向
        for ((dx, dy) in directions) {
            val newX = x + dx
            val newY = y + dy

            // 检查新坐标是否在边界内且能匹配下一个字符
            if (newX in board.indices && newY in board[0].indices && dfs(newX, newY, index + 1)) {
                return true
            }
        }

        // 恢复当前单元格
        board[x][y] = originalChar
        return false
    }

    // 遍历网格的每个单元格作为起点
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (dfs(i, j, 0)) {
                return true
            }
        }
    }

    return false
}
