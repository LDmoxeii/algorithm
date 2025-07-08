package com.only4.algorithm.version4k.extra

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
 * 本解法使用二分查找的思想，时间复杂度为O(log(min(m,n)))，满足题目要求的O(log(m+n))。
 * 关键思路是将问题转化为寻找第k小的元素，其中k是合并后数组的中间位置。
 *
 * 算法步骤:
 * 1. 确保nums1的长度小于等于nums2，如果不是则交换两个数组（为了优化算法效率）
 * 2. 计算合并后数组的中间位置，即k = (m+n+1)/2
 * 3. 使用二分查找在nums1中找到一个位置i，使得nums1[0...i-1]和nums2[0...j-1]构成合并后数组的左半部分
 *    其中j = k-i，确保左半部分的元素个数为k
 * 4. 根据中位数的定义计算结果:
 *    - 如果合并后数组长度为奇数，中位数是左半部分的最大值
 *    - 如果合并后数组长度为偶数，中位数是左半部分最大值和右半部分最小值的平均值
 *
 * 时间复杂度: O(log(min(m,n)))，其中m和n分别是两个数组的长度
 * 空间复杂度: O(1)，只使用了常数级别的额外空间
 */
fun findMedianSortedArraysOptimal(nums1: IntArray, nums2: IntArray): Double {
    // 确保nums1的长度小于等于nums2
    if (nums1.size > nums2.size) {
        return findMedianSortedArraysOptimal(nums2, nums1)
    }

    val m = nums1.size
    val n = nums2.size
    val totalLength = m + n
    val halfLength = (totalLength + 1) / 2 // 合并后数组的左半部分长度

    // 在nums1中进行二分查找
    var left = 0
    var right = m

    while (left <= right) {
        // nums1[0...i-1]构成合并后数组左半部分的一部分
        val i = (left + right) / 2
        // nums2[0...j-1]构成合并后数组左半部分的另一部分
        val j = halfLength - i

        // 检查边界条件
        val nums1LeftMax = if (i == 0) Int.MIN_VALUE else nums1[i - 1]
        val nums1RightMin = if (i == m) Int.MAX_VALUE else nums1[i]
        val nums2LeftMax = if (j == 0) Int.MIN_VALUE else nums2[j - 1]
        val nums2RightMin = if (j == n) Int.MAX_VALUE else nums2[j]

        // 核心判断：检查当前分割是否满足中位数的条件
        // 条件1: nums1左半部分的最大值 <= nums2右半部分的最小值
        // 条件2: nums2左半部分的最大值 <= nums1右半部分的最小值
        // 这两个条件确保了分割线左边的所有元素都小于或等于分割线右边的所有元素
        if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
            // 找到了正确的分割位置，现在可以计算中位数

            // 左半部分的最大值（即合并后数组的第(m+n)/2个元素，如果从0开始计数）
            val leftMax = maxOf(nums1LeftMax, nums2LeftMax)

            // 如果合并后数组长度为奇数
            // 例如：[1,2,3]和[4,5]合并后为[1,2,3,4,5]，中位数是3
            if (totalLength % 2 == 1) {
                // 中位数就是左半部分的最大值
                return leftMax.toDouble()
            }

            // 如果合并后数组长度为偶数
            // 例如：[1,2]和[3,4]合并后为[1,2,3,4]，中位数是(2+3)/2=2.5
            // 右半部分的最小值（即合并后数组的第(m+n)/2+1个元素，如果从0开始计数）
            val rightMin = minOf(nums1RightMin, nums2RightMin)

            // 中位数是左半部分最大值和右半部分最小值的平均值
            return (leftMax + rightMin) / 2.0
        }
        // 如果不满足条件，需要调整二分查找的范围
        else if (nums1LeftMax > nums2RightMin) {
            // 情况1: nums1左半部分的最大值 > nums2右半部分的最小值
            // 这意味着nums1的左半部分有元素太大，需要将分割线向左移动（减小i）
            // 例如：nums1=[5,6,7], nums2=[1,2,3]，当i=2时，nums1LeftMax=6 > nums2RightMin=3
            right = i - 1
        } else {
            // 情况2: nums2左半部分的最大值 > nums1右半部分的最小值
            // 这意味着nums1的左半部分元素太小，需要将分割线向右移动（增大i）
            // 例如：nums1=[1,2,3], nums2=[5,6,7]，当i=1时，nums2LeftMax=6 > nums1RightMin=2
            left = i + 1
        }
    }

    // 理论上不会执行到这里
    throw IllegalArgumentException("输入数组不符合要求")
}
