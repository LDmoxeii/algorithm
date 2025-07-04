package com.only4.algorithm.leetcode

class RepeatItem(val count: Int) {
    val sb = StringBuilder()
    override fun toString(): String = sb.toString().repeat(count)
}

fun decodeString(s: String): String {
    val stack = ArrayDeque<RepeatItem>().apply { add(RepeatItem(1)) }
    var num = StringBuilder()
    for (c in s) {
        when (c) {
            in '0'..'9' -> num.append(c)
            '[' -> stack.add(RepeatItem(num.toString().toIntOrNull() ?: 1)).run { num = StringBuilder() }
            ']' -> stack.removeLast().also { stack.last().sb.append(it.toString()) }
            else -> stack.last().sb.append(c)
        }
    }
    return stack.last().toString()
}

fun main() {
    println(decodeString("3[a2[c]]"))
}
