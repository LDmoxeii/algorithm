package com.only4.algorithm.version4k.leetcode

fun partitionLabels(s: String): List<Int> {
    if (s.isEmpty()) return emptyList()

    val lastPositions = IntArray(26)

    for (i in s.indices) {
        lastPositions[s[i] - 'a'] = i
    }

    val result = mutableListOf<Int>()
    var start = 0
    var end = 0

    for (i in s.indices) {
        end = maxOf(end, lastPositions[s[i] - 'a'])

        if (i == end) {
            result.add(end - start + 1)
            start = i + 1
        }
    }
    return result
}
