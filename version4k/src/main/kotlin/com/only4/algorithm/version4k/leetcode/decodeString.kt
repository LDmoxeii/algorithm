package com.only4.algorithm.version4k.leetcode

class RepeatItem(val count: Int) {
    val content = StringBuilder()

    override fun toString(): String = content.toString().repeat(count)
}

fun decodeString(s: String): String {
    val stack = ArrayDeque<RepeatItem>().apply { add(RepeatItem(1)) }
    var number = StringBuilder()

    for (c in s) {
        when (c) {
            in '0'..'9' -> number.append(c)
            '[' -> {
                val count = number.toString().toInt()
                stack.add(RepeatItem(count))
                number = StringBuilder()
            }
            ']' -> {
                val item = stack.removeLast()
                stack.last().content.append(item.toString())
            }

            else -> stack.last().content.append(c)
        }
    }

    return stack.last().toString()
}
