package com.only4.algorithm.version4k.leetcode

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val totalLength = nums1.size + nums2.size
    val mergedArray = IntArray(totalLength)

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
