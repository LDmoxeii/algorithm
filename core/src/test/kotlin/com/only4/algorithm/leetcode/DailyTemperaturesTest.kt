package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DailyTemperaturesTest {

    @Test
    fun `test example from problem description`() {
        // 示例: temperatures = [73,74,75,71,69,72,76,73] -> [1,1,4,2,1,1,0,0]
        val temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
        val expected = intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)
        assertArrayEquals(expected, dailyTemperatures(temperatures))
    }

    @Test
    fun `test increasing temperatures`() {
        // 递增温度: [30, 40, 50, 60] -> [1, 1, 1, 0]
        val temperatures = intArrayOf(30, 40, 50, 60)
        val expected = intArrayOf(1, 1, 1, 0)
        assertArrayEquals(expected, dailyTemperatures(temperatures))
    }

    @Test
    fun `test decreasing temperatures`() {
        // 递减温度: [60, 50, 40, 30] -> [0, 0, 0, 0]
        val temperatures = intArrayOf(60, 50, 40, 30)
        val expected = intArrayOf(0, 0, 0, 0)
        assertArrayEquals(expected, dailyTemperatures(temperatures))
    }

    @Test
    fun `test same temperatures`() {
        // 相同温度: [70, 70, 70, 70] -> [0, 0, 0, 0]
        val temperatures = intArrayOf(70, 70, 70, 70)
        val expected = intArrayOf(0, 0, 0, 0)
        assertArrayEquals(expected, dailyTemperatures(temperatures))
    }

    @Test
    fun `test single temperature`() {
        // 单个温度: [80] -> [0]
        val temperatures = intArrayOf(80)
        val expected = intArrayOf(0)
        assertArrayEquals(expected, dailyTemperatures(temperatures))
    }

    @Test
    fun `test complex pattern`() {
        // 复杂模式: [30, 60, 90, 60, 30, 90, 100] -> [1, 1, 0, 2, 1, 1, 0]
        val temperatures = intArrayOf(30, 60, 90, 60, 30, 90, 100)
        val expected = intArrayOf(1, 1, 4, 2, 1, 1, 0)
        assertArrayEquals(expected, dailyTemperatures(temperatures))
    }

    @Test
    fun `test temperatures with duplicates`() {
        // 包含重复温度: [73, 74, 75, 71, 69, 72, 76, 73, 76] -> [1, 1, 4, 2, 1, 1, 0, 1, 0]
        val temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73, 76)
        val expected = intArrayOf(1, 1, 4, 2, 1, 1, 0, 1, 0)
        assertArrayEquals(expected, dailyTemperatures(temperatures))
    }

    @Test
    fun `test large temperature differences`() {
        // 温度差异大: [30, 100, 31, 101] -> [1, 0, 1, 0]
        val temperatures = intArrayOf(30, 100, 102, 101)
        val expected = intArrayOf(1, 1, 0, 0)
        assertArrayEquals(expected, dailyTemperatures(temperatures))
    }
}
