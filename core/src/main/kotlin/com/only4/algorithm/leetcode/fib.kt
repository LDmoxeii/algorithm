package com.only4.algorithm.leetcode

fun fib(n: Int): Int {
    val memo = IntArray(n + 1) { 0 }
    if (n == 0) return 0
    if (n == 1) return 1
    if (memo[n] != 0) return memo[n]
    return fib(n - 2) + fib(n - 1)
}
