package com.only4.algorithm.leetcode

import kotlin.random.Random

/**
 * [215. 数组中的第K个最大元素](https://leetcode.com/problems/kth-largest-element-in-an-array/)
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例:
 * - 输入: [3,2,1,5,6,4] 和 k = 2
 * - 输出: 5
 *
 * - 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * - 输出: 4
 *
 * 解题思路:
 * 使用快速选择(Quick Select)算法，这是一种分治算法，类似于快速排序。
 * 1. 随机选择一个pivot元素
 * 2. 将数组分为三部分：大于pivot的元素、等于pivot的元素和小于pivot的元素
 * 3. 根据这三部分的大小关系，确定第k大的元素在哪一部分
 * 4. 递归地在相应部分中继续查找
 *
 * 时间复杂度: 平均O(n)，最坏情况O(n²)
 * 空间复杂度: O(n)，主要用于递归调用栈和创建分区列表
 *
 * @param nums 未排序的整数数组
 * @param k 要查找的第k个最大元素
 * @return 数组中的第k个最大元素
 */
fun findKthLargest(nums: IntArray, k: Int): Int {
    /**
     * 快速选择算法的递归实现
     *
     * @param nums 当前处理的数组
     * @param k 要查找的第k个最大元素
     * @return 第k个最大元素
     */
    fun quickSelect(nums: List<Int>, k: Int): Int {
        // 随机选择pivot元素，减少最坏情况的概率
        val pivot = nums[Random.nextInt(nums.size)]

        // 将数组分为三部分：大于pivot、等于pivot和小于pivot
        val bigger = mutableListOf<Int>()  // 大于pivot的元素
        val equal = mutableListOf<Int>()   // 等于pivot的元素
        val smaller = mutableListOf<Int>() // 小于pivot的元素

        // 遍历数组，将元素分配到相应的部分
        for (num in nums) {
            when {
                num > pivot -> bigger.add(num)
                num == pivot -> equal.add(num)
                num < pivot -> smaller.add(num)
            }
        }

        // 根据三个部分的大小关系，确定第k大的元素在哪一部分
        return when {
            k <= bigger.size -> quickSelect(bigger, k)
            k <= bigger.size + equal.size -> pivot
            else -> quickSelect(smaller, k - bigger.size - equal.size)
        }
    }

    return quickSelect(nums.toList(), k)
}
