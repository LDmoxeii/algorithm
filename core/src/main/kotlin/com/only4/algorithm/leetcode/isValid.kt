package com.only4.algorithm.leetcode

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    for (c in s) {
        when (c) {
            '(', '{', '[' -> stack.addLast(c)
            ')' -> if (stack.isNotEmpty() && stack.last() == '(') stack.removeLast() else return false
            '}' -> if (stack.isNotEmpty() && stack.last() == '{') stack.removeLast() else return false
            ']' -> if (stack.isNotEmpty() && stack.last() == '[') stack.removeLast() else return false
        }
    }
    return stack.isEmpty()
}
