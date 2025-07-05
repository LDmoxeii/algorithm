package com.only4.algorithm.leetcode

/**
 * [394. 字符串解码](https://leetcode.com/problems/decode-string/)
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 * 注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * - 输入: s = "3[a]2[bc]" 输出: "aaabcbc"
 * - 输入: s = "3[a2[c]]" 输出: "accaccacc"
 * - 输入: s = "2[abc]3[cd]ef" 输出: "abcabccdcdcdef"
 */

/**
 * 表示一个重复项，包含重复次数和要重复的内容
 *
 * @property count 重复次数
 */
class RepeatItem(val count: Int) {
    /**
     * 存储要重复的内容
     */
    val sb = StringBuilder()

    /**
     * 将内容按照指定次数重复
     *
     * @return 重复后的字符串
     */
    override fun toString(): String = sb.toString().repeat(count)
}

/**
 * 解码字符串
 *
 * 解题思路:
 * 使用栈来解决嵌套括号问题。遍历字符串，根据不同字符类型执行不同操作：
 * 1. 数字：累积数字值，用于后续的重复次数
 * 2. '[' : 创建新的RepeatItem并入栈，重置数字累积器
 * 3. ']' : 弹出栈顶RepeatItem，将其重复结果添加到新栈顶的内容中
 * 4. 字母：直接添加到当前栈顶RepeatItem的内容中
 *
 * 时间复杂度: O(n)，其中n是解码后字符串的长度
 * 空间复杂度: O(m)，其中m是编码字符串的长度，主要用于栈的存储
 *
 * @param s 编码后的字符串
 * @return 解码后的字符串
 */
fun decodeString(s: String): String {
    // 初始化栈，添加一个计数为1的RepeatItem作为根节点
    val stack = ArrayDeque<RepeatItem>().apply { add(RepeatItem(1)) }
    var num = StringBuilder()

    for (c in s) {
        when (c) {
            in '0'..'9' -> num.append(c)
            '[' -> {
                // 将累积的数字转为整数作为重复次数，创建新的RepeatItem并入栈
                val count = num.toString().toIntOrNull() ?: 1
                stack.add(RepeatItem(count))
                num = StringBuilder() // 重置数字累积器
            }

            ']' -> {
                // 弹出栈顶元素，将其重复结果添加到新栈顶的内容中
                val repeatItem = stack.removeLast()
                stack.last().sb.append(repeatItem.toString())
            }

            else -> stack.last().sb.append(c) // 字母直接添加到当前内容
        }
    }

    // 返回根节点的内容
    return stack.last().toString()
}
