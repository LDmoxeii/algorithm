package com.only4.algorithm.leetcode

fun uniquePaths(rows: Int, cols: Int): Int {
    val location = mutableMapOf<Pair<Int, Int>, Int>().also {
        for (row in 1..rows) {
            it[row to 1] = 1
        }
        for (col in 1..cols) {
            it[1 to col] = 1
        }
    }

    for (row in 2..rows) {
        for (col in 2..cols) {
            location[row to col] = location[row - 1 to col]!! + location[row to col - 1]!!

        }
    }

    return location[rows to cols]!!
}

fun main() {
    println(uniquePaths(3, 7))
}
