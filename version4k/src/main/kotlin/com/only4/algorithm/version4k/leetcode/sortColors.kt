package com.only4.algorithm.version4k.leetcode

/**
 * [75. Sort Colors](https://leetcode.com/problems/sort-colors)
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红、白、蓝三种颜色。
 * 你不能使用库的排序函数。
 *
 * 解题思路：
 * 经典的荷兰国旗问题。可以使用双指针（或三指针）法：
 * - 维护三个区域：[0,p0) 全为0，[p0,p1) 全为1，[p1,i) 未处理，[i,n) 全为2。
 * - 遍历数组，将0放到前面，2放到后面，1自然在中间。
 * - 只需一次遍历，时间复杂度O(n)，空间复杂度O(1)。
 *
 * 其他常见解法：
 * - 计数排序：统计0、1、2出现次数，再重写数组，需两次遍历。
 *
 * 用例场景：
 * - 输入 [2,0,2,1,1,0]，输出 [0,0,1,1,2,2]
 * - 输入 [2,0,1]，输出 [0,1,2]
 * - 适用于需要原地对仅有三种元素的数组进行排序的场景。
 */
fun sortColors(nums: IntArray) {
    var low = 0
    var mid = 0
    var high = nums.lastIndex

    while (mid <= high) {
        when (nums[mid]) {
            0 -> {
                nums[mid] = nums[low].also { nums[low] = nums[mid] }
                low++
                mid++
            }

            1 -> {
                mid++
            }

            2 -> {
                nums[mid] = nums[high].also { nums[high] = nums[mid] }
                high--
            }
        }
    }
}
