package com.only4.algorithm.leetcode

/**
 * [20. 有效的括号](https://leetcode.com/problems/valid-parentheses/)
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 3. 每个右括号都有一个对应的左括号。
 *
 * 示例:
 * - 输入: "()" 输出: true
 * - 输入: "()[]{}" 输出: true
 * - 输入: "(]" 输出: false
 * - 输入: "([)]" 输出: false
 * - 输入: "{[]}" 输出: true
 *
 * 解题思路:
 * 使用栈来解决这个问题。遍历字符串，当遇到开括号时，将其压入栈中；
 * 当遇到闭括号时，检查栈顶元素是否为对应的开括号，如果是则弹出栈顶元素，否则返回false。
 * 最后，如果栈为空，则字符串有效，否则无效。
 *
 * 时间复杂度: O(n)，其中n是字符串长度，需要遍历整个字符串
 * 空间复杂度: O(n)，最坏情况下，栈的大小为字符串长度
 */
fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    val bracketPairs = mapOf(
        ')' to '(',
        '}' to '{',
        ']' to '['
    )

    for (char in s) {
        when (char) {
            in "({[" -> stack.addLast(char)
            in ")}]" -> if (stack.isEmpty() || stack.removeLast() != bracketPairs[char]) return false
        }
    }

    return stack.isEmpty()
}
