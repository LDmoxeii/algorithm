package com.only4.algorithm.leetcode

/**
 * [42. 接雨水](https://leetcode.cn/problems/trapping-rain-water/)
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 提示：
 * - n == height.length
 * - 1 <= n <= 2 * 10^4
 * - 0 <= height[i] <= 10^5
 *
 * 解题思路：使用双指针法。维护左右两个指针和左右两边的最大高度。
 * 1. 初始化左右指针分别指向数组的两端，同时记录左右两边的最大高度。
 * 2. 比较左右两边的最大高度，选择较小的一边进行移动（木桶原理，水位由短板决定）。
 * 3. 如果左边较小，则左指针向右移动；如果右边较小，则右指针向左移动。
 * 4. 在移动过程中，计算当前位置能接的水量（较小的最大高度减去当前高度），并更新对应的最大高度。
 * 5. 重复上述过程直到左右指针相遇。
 *
 * 时间复杂度：O(n)，其中n是数组的长度，只需要遍历一次数组
 * 空间复杂度：O(1)，只使用了常数额外空间
 *
 * @param heights 表示柱子高度的整数数组
 * @return 能接的雨水总量
 */
fun trap(heights: IntArray): Int {
    if (heights.isEmpty() || heights.size < 3) return 0

    var totalWater = 0
    var leftMax = heights[0];
    var rightMax = heights[heights.lastIndex]
    var left = 0;
    var right = heights.lastIndex

    while (left < right) {
        // 根据木桶原理，水位由较低的一边决定
        if (leftMax < rightMax) {
            // 左边较低，移动左指针
            left++
            // 如果当前高度小于左边最大高度，可以接水
            if (heights[left] < leftMax) {
                totalWater += leftMax - heights[left]
            } else {
                // 更新左边最大高度
                leftMax = heights[left]
            }
        } else {
            // 右边较低或相等，移动右指针
            right--
            // 如果当前高度小于右边最大高度，可以接水
            if (heights[right] < rightMax) {
                totalWater += rightMax - heights[right]
            } else {
                // 更新右边最大高度
                rightMax = heights[right]
            }
        }
    }

    return totalWater
}
