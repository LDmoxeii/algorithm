package com.only4.algorithm.leetcode

/**
 * [72. 编辑距离](https://leetcode.com/problems/edit-distance/)
 *
 * 给你两个单词 word1 和 word2，请返回将 word1 转换成 word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * 1. 插入一个字符
 * 2. 删除一个字符
 * 3. 替换一个字符
 *
 * 示例:
 * - 输入: word1 = "horse", word2 = "ros"
 * - 输出: 3
 * - 解释:
 *   horse -> rorse (将 'h' 替换为 'r')
 *   rorse -> rose (删除 'r')
 *   rose -> ros (删除 'e')
 *
 * - 输入: word1 = "intention", word2 = "execution"
 * - 输出: 5
 * - 解释:
 *   intention -> inention (删除 't')
 *   inention -> enention (将 'i' 替换为 'e')
 *   enention -> exention (将 'n' 替换为 'x')
 *   exention -> exection (将 'n' 替换为 'c')
 *   exection -> execution (插入 'u')
 *
 * 解题思路:
 * 使用动态规划（自顶向下）解决此问题，通过记忆化搜索避免重复计算。
 * 定义dp(i,j)表示将word1[0...i]转换为word2[0...j]所需的最少操作数。
 *
 * 状态转移方程:
 * 1. 如果word1[i] == word2[j]，则dp(i,j) = dp(i-1,j-1)
 * 2. 否则，dp(i,j) = min(
 *      dp(i,j-1) + 1,    // 插入操作
 *      dp(i-1,j) + 1,    // 删除操作
 *      dp(i-1,j-1) + 1   // 替换操作
 *    )
 *
 * 边界条件:
 * 1. 如果i == -1，返回j + 1（将空字符串转换为word2[0...j]需要j+1次插入操作）
 * 2. 如果j == -1，返回i + 1（将word1[0...i]转换为空字符串需要i+1次删除操作）
 *
 * 时间复杂度: O(m*n)，其中m和n分别是两个单词的长度
 * 空间复杂度: O(m*n)，需要一个m*n大小的备忘录
 *
 * @param word1 第一个单词
 * @param word2 第二个单词
 * @return 将word1转换为word2所需的最少操作数
 */
fun minDistance(word1: String, word2: String): Int {
    // 使用备忘录避免重复计算
    val memo = mutableMapOf<Pair<Int, Int>, Int>()

    /**
     * 递归函数，计算将word1[0...i]转换为word2[0...j]所需的最少操作数
     *
     * @param i word1的当前索引
     * @param j word2的当前索引
     * @return 最少操作数
     */
    fun dp(i: Int, j: Int): Int {
        // 边界条件：如果word1为空，则需要j+1次插入操作
        if (i == -1) return j + 1

        // 边界条件：如果word2为空，则需要i+1次删除操作
        if (j == -1) return i + 1

        // 如果已经计算过，直接返回结果
        if (memo.containsKey(i to j)) return memo[i to j]!!

        // 计算当前状态的最少操作数
        val result = if (word1[i] == word2[j]) {
            // 如果当前字符相同，无需操作，直接考虑前面的子问题
            dp(i - 1, j - 1)
        } else {
            // 如果当前字符不同，取三种操作的最小值
            minOf(
                dp(i, j - 1) + 1,     // 插入操作
                dp(i - 1, j) + 1,     // 删除操作
                dp(i - 1, j - 1) + 1  // 替换操作
            )
        }

        // 将结果存入备忘录
        memo[i to j] = result
        return result
    }

    // 从两个单词的末尾开始计算
    return dp(word1.lastIndex, word2.lastIndex)
}
