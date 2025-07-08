package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CanFinishTest {

    @Test
    fun `test no prerequisites`() {
        // 没有任何先修课程要求，应该可以完成所有课程
        val numCourses = 5
        val prerequisites = arrayOf<IntArray>()

        val result = canFinish(numCourses, prerequisites)

        assertTrue(result)
    }

    @Test
    fun `test simple dependency without cycle`() {
        // 简单的依赖关系，无环
        // 课程 1 依赖课程 0
        val numCourses = 2
        val prerequisites = arrayOf(intArrayOf(1, 0))

        val result = canFinish(numCourses, prerequisites)

        assertTrue(result)
    }

    @Test
    fun `test simple cycle`() {
        // 简单的环形依赖
        // 课程 0 依赖课程 1，课程 1 依赖课程 0
        val numCourses = 2
        val prerequisites = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )

        val result = canFinish(numCourses, prerequisites)

        assertFalse(result)
    }

    @Test
    fun `test complex dependency without cycle`() {
        // 复杂的依赖关系，无环
        // 0 -> 1 -> 3
        // |    |
        // v    v
        // 2    4
        val numCourses = 5
        val prerequisites = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(3, 1),
            intArrayOf(4, 1)
        )

        val result = canFinish(numCourses, prerequisites)

        assertTrue(result)
    }

    @Test
    fun `test complex cycle`() {
        // 复杂的环形依赖
        // 0 -> 1 -> 2 -> 3 -> 4 -> 0
        val numCourses = 5
        val prerequisites = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 1),
            intArrayOf(3, 2),
            intArrayOf(4, 3),
            intArrayOf(0, 4)
        )

        val result = canFinish(numCourses, prerequisites)

        assertFalse(result)
    }

    @Test
    fun `test disconnected components`() {
        // 多个独立的组件，无环
        // 0 -> 1    3 -> 4
        // |
        // v
        // 2
        val numCourses = 5
        val prerequisites = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(4, 3)
        )

        val result = canFinish(numCourses, prerequisites)

        assertTrue(result)
    }

    @Test
    fun `test disconnected components with cycle`() {
        // 多个独立的组件，其中一个有环
        // 0 -> 1    3 -> 4
        // ^    |    ^    |
        // |    v    |    v
        // +--- 2    +--- 5
        val numCourses = 6
        val prerequisites = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 1),
            intArrayOf(0, 2), // 环
            intArrayOf(4, 3),
            intArrayOf(5, 4),
            intArrayOf(3, 5)  // 环
        )

        val result = canFinish(numCourses, prerequisites)

        assertFalse(result)
    }

    @Test
    fun `test self loop`() {
        // 自环
        // 0 -> 0
        val numCourses = 1
        val prerequisites = arrayOf(
            intArrayOf(0, 0)
        )

        val result = canFinish(numCourses, prerequisites)

        assertFalse(result)
    }

    @Test
    fun `test large number of courses`() {
        // 大量课程，无环
        val numCourses = 1000
        val prerequisites = Array(numCourses - 1) { i ->
            intArrayOf(i + 1, i) // 形成一条长链
        }

        val result = canFinish(numCourses, prerequisites)

        assertTrue(result)
    }

    @Test
    fun `test isolated courses`() {
        // 完全独立的课程，没有依赖关系
        val numCourses = 10
        val prerequisites = arrayOf<IntArray>()

        val result = canFinish(numCourses, prerequisites)

        assertTrue(result)
    }
}
