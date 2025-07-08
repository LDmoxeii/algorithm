package com.only4.algorithm.version4k.leetcode

import java.util.*

/**
 * [239. 滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/)
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------              -----
 * [1  3  -1] -3  5  3  6  7    3
 *  1 [3  -1  -3] 5  3  6  7    3
 *  1  3 [-1  -3  5] 3  6  7    5
 *  1  3  -1 [-3  5  3] 6  7    5
 *  1  3  -1  -3 [5  3  6] 7    6
 *  1  3  -1  -3  5 [3  6  7]   7
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 提示：
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 * - 1 <= k <= nums.length
 *
 * 解题思路：使用优先队列（最大堆）实现。
 * 1. 使用优先队列存储窗口中的元素，按照值从大到小排序
 * 2. 为了知道元素是否在当前窗口中，需要同时存储元素的索引
 * 3. 遍历数组，每次将当前元素加入队列，并移除不在当前窗口范围内的元素
 * 4. 队列的堆顶元素即为当前窗口的最大值
 *
 * 时间复杂度：O(n log k)，其中n为数组长度，k为窗口大小
 * 空间复杂度：O(k)，优先队列中最多存储k个元素
 *
 * @param nums 整数数组
 * @param k 滑动窗口大小
 * @return 每个窗口的最大值组成的数组
 */
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    // 边界条件检查
    if (nums.isEmpty() || k <= 0) return IntArray(0)
    if (k == 1) return nums

    // 结果数组，长度为 nums.length - k + 1
    val result = IntArray(nums.size - k + 1)

    // 创建最大堆，按值降序排列
    val maxHeap = PriorityQueue<IndexedValue> { a, b ->
        when {
            a.value != b.value -> b.value.compareTo(a.value) // 值降序
            else -> b.index.compareTo(a.index) // 值相等时按索引降序，保持稳定性
        }
    }

    // 初始化第一个窗口
    for (i in 0 until k) {
        maxHeap.offer(IndexedValue(i, nums[i]))
    }

    // 第一个窗口的最大值
    result[0] = maxHeap.peek().value

    // 处理剩余的窗口
    for (i in k until nums.size) {
        // 添加新元素到堆中
        maxHeap.offer(IndexedValue(i, nums[i]))

        // 移除不在当前窗口范围内的元素
        // 当前窗口范围是 [i-k+1, i]
        while (maxHeap.isNotEmpty() && maxHeap.peek().index < i - k + 1) {
            maxHeap.poll()
        }

        // 当前窗口的最大值就是堆顶元素
        result[i - k + 1] = maxHeap.peek().value
    }

    return result
}

/**
 * 封装索引和值的配对，用于优先队列中
 */
private data class IndexedValue(val index: Int, val value: Int)

/**
 * 双端队列实现的滑动窗口最大值，时间复杂度O(n)
 * 这是一个更优的实现，使用双端队列保存可能成为窗口最大值的元素的索引
 */
fun maxSlidingWindowOptimized(nums: IntArray, k: Int): IntArray {
    // 边界条件检查
    if (nums.isEmpty() || k <= 0) return IntArray(0)
    if (k == 1) return nums

    val result = IntArray(nums.size - k + 1)
    // 使用双端队列存储可能成为窗口最大值的元素的索引
    val deque = LinkedList<Int>()

    for (i in nums.indices) {
        // 移除队列中所有小于当前元素的值，因为它们不可能是后续窗口的最大值
        while (deque.isNotEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast()
        }

        // 添加当前索引到队列
        deque.offerLast(i)

        // 移除不在当前窗口范围内的元素
        if (deque.peekFirst() == i - k) {
            deque.pollFirst()
        }

        // 当形成第一个完整窗口后，开始记录最大值
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.peekFirst()]
        }
    }

    return result
}
