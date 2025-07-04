package com.only4.algorithm.leetcode

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val array = IntArray(nums1.size + nums2.size)
    var (p1, p2, index) = Triple(0, 0, 0)
    while (p1 < nums1.size && p2 < nums2.size) {
        array[index++] = if (nums1[p1] < nums2[p2]) nums1[p1++]
        else nums2[p2++]
    }

    if (p1 == nums1.size) while (p2 != nums2.size) array[index++] = nums2[p2++]
    if (p2 == nums2.size) while (p1 != nums1.size) array[index++] = nums1[p1++]

    val size = array.size
    return if (size % 2.0 == 0.0) (array[size / 2] + array[size / 2 - 1]) / 2.0
    else array[size / 2].toDouble()
}

fun main() {
    println(findMedianSortedArrays(intArrayOf(1, 2, 3, 4, 5), intArrayOf(6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)))
}
