package com.only4.algorithm.extra

import java.math.BigInteger

class Result(var value: BigInteger = BigInteger.valueOf(1L))

tailrec fun factorial(num: Int, result: Result) {
    when {
        num == 0 -> result.value = result.value * BigInteger.valueOf(1L)
        else -> {
            result.value = result.value * BigInteger.valueOf(num.toLong())
            factorial(num - 1, result)
        }
    }
}

fun main() {
    val result = Result()
    factorial(100000, result)
    println(result.value)
}
