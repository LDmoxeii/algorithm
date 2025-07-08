package com.only4.algorithm.version4k.leetcode

/**
 * [118. 杨辉三角](https://leetcode.com/problems/pascals-triangle/)
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数之和。
 *
 * 示例:
 * - 输入: numRows = 5
 * - 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * - 输入: numRows = 1
 * - 输出: [[1]]
 *
 * 解题思路:
 * 1. 创建一个二维列表，每一行的长度等于行号+1
 * 2. 初始化每一行的所有元素为1
 * 3. 从第3行开始(索引为2)，对于每一行的第j个元素(不包括首尾元素)，
 *    其值等于上一行的第j-1个元素与第j个元素之和
 *
 * 时间复杂度: O(numRows²)，需要生成的元素总数是1+2+...+numRows，约为numRows²/2
 * 空间复杂度: O(numRows²)，需要存储的元素总数约为numRows²/2
 *
 * @param numRows 要生成的杨辉三角的行数
 * @return 包含杨辉三角前numRows行的二维列表
 */
fun generate(numRows: Int): List<List<Int>> {
    // 参数校验
    if (numRows <= 0) return emptyList()

    // 创建结果列表，每行的长度为i+1，初始值都为1
    val result = List(numRows) { i -> MutableList(i + 1) { 1 } }

    // 从第3行(索引为2)开始填充
    for (i in 2 until numRows) {
        // 第一个和最后一个元素总是1，所以从第二个元素开始，到倒数第二个元素结束
        for (j in 1 until i) {
            // 当前元素等于上一行的左上方元素和右上方元素之和
            result[i][j] = result[i - 1][j - 1] + result[i - 1][j]
        }
    }

    return result
}
