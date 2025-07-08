package com.only4.algorithm.version4k.leetcode

/**
 * [155. 最小栈](https://leetcode.com/problems/min-stack/)
 *
 * 设计一个支持 push、pop、top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 * - MinStack() 初始化堆栈对象。
 * - void push(int val) 将元素val推入堆栈。
 * - void pop() 删除堆栈顶部的元素。
 * - int top() 获取堆栈顶部的元素。
 * - int getMin() 检索堆栈中的最小元素。
 *
 * 示例:
 * ```
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   // 返回 -3
 * minStack.pop();
 * minStack.top();      // 返回 0
 * minStack.getMin();   // 返回 -2
 * ```
 *
 * 解题思路:
 * 使用一个栈来存储元素对，每个元素对包含两个值：当前值和当前栈中的最小值。
 * 每次push操作时，计算新元素和当前最小值中的较小值，并与新元素一起存储。
 * 这样在任何时候，栈顶元素的第二个值就是当前栈中的最小值，实现O(1)时间复杂度的getMin操作。
 *
 * 时间复杂度:
 * - push: O(1)
 * - pop: O(1)
 * - top: O(1)
 * - getMin: O(1)
 *
 * 空间复杂度: O(n)，其中n是栈中元素的数量
 */
class MinStack {
    // 使用Pair存储当前值和当前最小值，更符合Kotlin风格
    private val stack = ArrayDeque<Pair<Int, Int>>()

    init {
        // 初始化栈，添加一个哨兵值，方便后续操作
        stack.addLast(Pair(0, Int.MAX_VALUE))
    }

    /**
     * 将元素val推入堆栈
     * @param val 要推入的元素值
     */
    fun push(value: Int) {
        // 计算新的最小值并与当前值一起存储
        stack.addLast(Pair(value, minOf(getMin(), value)))
    }

    /**
     * 删除堆栈顶部的元素
     */
    fun pop() {
        stack.removeLast()
    }

    /**
     * 获取堆栈顶部的元素
     * @return 栈顶元素的值
     */
    fun top(): Int = stack.last().first

    /**
     * 检索堆栈中的最小元素
     * @return 栈中的最小值
     */
    fun getMin(): Int = stack.last().second
}
