package com.only4.algorithm.version4k.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinStackTest {

    @Test
    fun `test example from problem description`() {
        val minStack = MinStack()
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-3)

        // 测试getMin()，应该返回-3
        assertEquals(-3, minStack.getMin())

        minStack.pop()

        // 测试top()，应该返回0
        assertEquals(0, minStack.top())

        // 测试getMin()，应该返回-2
        assertEquals(-2, minStack.getMin())
    }

    @Test
    fun `test with increasing values`() {
        val minStack = MinStack()
        minStack.push(1)
        minStack.push(2)
        minStack.push(3)

        // 最小值应该是1
        assertEquals(1, minStack.getMin())

        // 栈顶应该是3
        assertEquals(3, minStack.top())

        minStack.pop()

        // 栈顶应该是2
        assertEquals(2, minStack.top())

        // 最小值仍然是1
        assertEquals(1, minStack.getMin())
    }

    @Test
    fun `test with decreasing values`() {
        val minStack = MinStack()
        minStack.push(3)
        minStack.push(2)
        minStack.push(1)

        // 最小值应该是1
        assertEquals(1, minStack.getMin())

        // 栈顶应该是1
        assertEquals(1, minStack.top())

        minStack.pop()

        // 栈顶应该是2
        assertEquals(2, minStack.top())

        // 最小值应该是2
        assertEquals(2, minStack.getMin())

        minStack.pop()

        // 栈顶应该是3
        assertEquals(3, minStack.top())

        // 最小值应该是3
        assertEquals(3, minStack.getMin())
    }

    @Test
    fun `test with duplicate values`() {
        val minStack = MinStack()
        minStack.push(1)
        minStack.push(1)
        minStack.push(1)

        // 最小值应该是1
        assertEquals(1, minStack.getMin())

        minStack.pop()

        // 最小值仍然是1
        assertEquals(1, minStack.getMin())

        minStack.pop()

        // 最小值仍然是1
        assertEquals(1, minStack.getMin())
    }

    @Test
    fun `test with mixed values`() {
        val minStack = MinStack()
        minStack.push(5)
        minStack.push(2)
        minStack.push(7)
        minStack.push(1)
        minStack.push(3)

        // 最小值应该是1
        assertEquals(1, minStack.getMin())

        // 栈顶应该是3
        assertEquals(3, minStack.top())

        minStack.pop()

        // 最小值仍然是1
        assertEquals(1, minStack.getMin())

        minStack.pop()

        // 最小值应该是2
        assertEquals(2, minStack.getMin())

        minStack.push(0)

        // 最小值应该是0
        assertEquals(0, minStack.getMin())
    }
}
