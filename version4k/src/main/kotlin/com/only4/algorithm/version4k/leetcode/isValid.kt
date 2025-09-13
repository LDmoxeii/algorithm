package com.only4.algorithm.version4k.leetcode

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    for (c in s) {
        when (c) {
            '(', '[', '{' -> stack.addLast(c)
            else -> {
                if (stack.isEmpty()) return false

                val top = stack.removeLast()
                when (c) {
                    ')' -> if (top != '(') return false
                    ']' -> if (top != '[') return false
                    '}' -> if (top != '{') return false
                }
            }
        }
    }

    return stack.isEmpty()
}
