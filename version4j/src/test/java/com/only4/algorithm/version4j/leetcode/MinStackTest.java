package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinStackTest {

    @Test
    public void testBasicOperations() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        // 检查最小值是否为-3
        assertEquals(-3, minStack.getMin());

        // 弹出栈顶元素(-3)
        minStack.pop();

        // 检查栈顶是否为0
        assertEquals(0, minStack.top());

        // 检查最小值是否更新为-2
        assertEquals(-2, minStack.getMin());
    }

    @Test
    public void testSameValues() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(5);
        minStack.push(5);

        // 检查最小值是否为5
        assertEquals(5, minStack.getMin());

        // 检查栈顶是否为5
        assertEquals(5, minStack.top());

        // 弹出一个元素
        minStack.pop();

        // 检查最小值是否仍为5
        assertEquals(5, minStack.getMin());

        // 再弹出一个元素
        minStack.pop();

        // 检查最小值是否仍为5
        assertEquals(5, minStack.getMin());
    }

    @Test
    public void testChangingMinimum() {
        MinStack minStack = new MinStack();
        minStack.push(10);  // 最小值: 10
        assertEquals(10, minStack.getMin());

        minStack.push(5);   // 最小值变为: 5
        assertEquals(5, minStack.getMin());

        minStack.push(15);  // 最小值仍为: 5
        assertEquals(5, minStack.getMin());

        minStack.pop();     // 弹出15, 最小值仍为: 5
        assertEquals(5, minStack.getMin());

        minStack.pop();     // 弹出5, 最小值变回: 10
        assertEquals(10, minStack.getMin());
    }

    @Test
    public void testNegativeAndPositiveValues() {
        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(5);
        minStack.push(-20);
        minStack.push(0);

        // 检查最小值是否为-20
        assertEquals(-20, minStack.getMin());

        // 检查栈顶是否为0
        assertEquals(0, minStack.top());

        // 弹出两个元素
        minStack.pop(); // 弹出0
        minStack.pop(); // 弹出-20

        // 检查最小值是否更新为-10
        assertEquals(-10, minStack.getMin());
    }

    @Test
    public void testPushPopSequence() {
        MinStack minStack = new MinStack();

        // 第一轮：推入然后全部弹出
        minStack.push(3);
        minStack.push(1);
        minStack.push(2);
        assertEquals(1, minStack.getMin());

        minStack.pop(); // 弹出2
        assertEquals(1, minStack.getMin());

        minStack.pop(); // 弹出1
        assertEquals(3, minStack.getMin());

        minStack.pop(); // 弹出3

        // 第二轮：推入新的元素
        minStack.push(7);
        minStack.push(2);
        minStack.push(3);
        assertEquals(2, minStack.getMin());
        assertEquals(3, minStack.top());
    }

    @Test
    public void testLargeValues() {
        MinStack minStack = new MinStack();
        minStack.push(Integer.MAX_VALUE);
        minStack.push(Integer.MAX_VALUE - 1);

        assertEquals(Integer.MAX_VALUE - 1, minStack.getMin());
        assertEquals(Integer.MAX_VALUE - 1, minStack.top());

        minStack.push(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE - 1, minStack.getMin());

        minStack.pop();
        assertEquals(Integer.MAX_VALUE - 1, minStack.top());
        assertEquals(Integer.MAX_VALUE - 1, minStack.getMin());
    }
}
