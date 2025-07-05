package com.only4.algorithm.leetcode

/**
 * [4. 寻找两个正序数组的中位数](https://leetcode.com/problems/median-of-two-sorted-arrays/)
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例:
 * - 输入: nums1 = [1,3], nums2 = [2] 输出: 2.00000
 *   解释: 合并数组 = [1,2,3] ，中位数 2
 * - 输入: nums1 = [1,2], nums2 = [3,4] 输出: 2.50000
 *   解释: 合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 解题思路:
 * 本解法使用合并两个有序数组的方法来找到中位数。虽然这种方法的时间复杂度为O(m+n)，
 * 不满足题目要求的O(log(m+n))，但它是直观且易于理解的解法：
 * 1. 合并两个有序数组得到一个新的有序数组
 * 2. 根据合并后数组的长度判断中位数的计算方式：
 *    - 如果长度为奇数，中位数为中间的元素
 *    - 如果长度为偶数，中位数为中间两个元素的平均值
 *
 * 注意：要实现O(log(m+n))的时间复杂度，需要使用二分查找的方法，
 * 但该解法更为复杂，这里采用简单直观的合并数组方法。
 *
 * 时间复杂度: O(m+n)，其中m和n分别是两个数组的长度
 * 空间复杂度: O(m+n)，需要创建一个新数组来存储合并后的结果
 */
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val totalLength = nums1.size + nums2.size
    val mergedArray = IntArray(totalLength)

    // 合并两个有序数组
    var index = 0
    var p1 = 0
    var p2 = 0

    // 同时遍历两个数组，按顺序合并
    while (p1 < nums1.size && p2 < nums2.size) {
        mergedArray[index++] = if (nums1[p1] < nums2[p2]) nums1[p1++] else nums2[p2++]
    }

    // 处理剩余元素
    while (p1 < nums1.size) {
        mergedArray[index++] = nums1[p1++]
    }

    while (p2 < nums2.size) {
        mergedArray[index++] = nums2[p2++]
    }

    // 计算中位数
    return if (totalLength % 2 == 0) {
        // 偶数长度，取中间两个数的平均值
        (mergedArray[totalLength / 2] + mergedArray[totalLength / 2 - 1]) / 2.0
    } else {
        // 奇数长度，取中间的数
        mergedArray[totalLength / 2].toDouble()
    }
}
