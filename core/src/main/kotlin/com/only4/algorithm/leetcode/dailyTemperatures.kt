package com.only4.algorithm.leetcode

/**
 * [739. 每日温度](https://leetcode.com/problems/daily-temperatures/)
 *
 * 给定一个整数数组 temperatures，表示每天的温度，返回一个数组 answer，其中 answer[i] 是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例:
 * - 输入: temperatures = [73,74,75,71,69,72,76,73]
 * - 输出: [1,1,4,2,1,1,0,0]
 *
 * 解题思路:
 * 使用单调栈解决此问题。遍历温度数组，对于每个温度，我们将其与栈顶元素比较：
 * 1. 如果当前温度高于栈顶温度，则找到了栈顶温度的下一个更高温度
 * 2. 计算两天之间的间隔，并将结果存储在结果数组中
 * 3. 弹出栈顶元素，继续比较当前温度与新的栈顶温度
 * 4. 将当前天的索引压入栈中，等待找到其下一个更高温度
 *
 * 栈中存储的是温度数组的索引，而不是温度值，这样可以方便计算天数差
 *
 * 时间复杂度: O(n)，其中n是温度数组的长度，每个元素最多入栈和出栈一次
 * 空间复杂度: O(n)，最坏情况下栈的大小为n
 *
 * @param temperatures 每日温度数组
 * @return 等待更高温度的天数数组
 */
fun dailyTemperatures(temperatures: IntArray): IntArray {
    // 用于存储索引的单调递减栈（温度值递减）
    val stack = ArrayDeque<Int>()
    // 初始化结果数组，默认值为0
    val result = IntArray(temperatures.size)

    // 遍历每天的温度
    temperatures.forEachIndexed { day, temperature ->
        // 当栈不为空且当前温度高于栈顶索引对应的温度时
        while (stack.isNotEmpty() && temperatures[stack.last()] < temperature) {
            // 弹出栈顶索引
            val prevDay = stack.removeLast()
            // 计算等待天数并存储结果
            result[prevDay] = day - prevDay
        }
        // 将当前天的索引入栈
        stack.addLast(day)
    }

    // 返回结果数组
    return result
}
