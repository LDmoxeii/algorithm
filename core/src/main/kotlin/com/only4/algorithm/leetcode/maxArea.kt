package com.only4.algorithm.leetcode

/**
 * [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/)
 *
 * 给定一个长度为 n 的整数数组 height。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：height = [1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 提示：
 * - n == height.length
 * - 2 <= n <= 10^5
 * - 0 <= height[i] <= 10^4
 *
 * 解题思路：使用双指针法，一个指向数组开头，一个指向数组结尾。计算当前两个指针构成的容器的容量，
 * 然后移动高度较小的那个指针（因为容器的高度由较短的一边决定）。这样可以保证我们不会错过可能的最大容量。
 *
 * 时间复杂度：O(n)，其中n是数组的长度，只需要遍历一次数组
 * 空间复杂度：O(1)，只使用了常数额外空间
 *
 * @param height 表示垂线高度的整数数组
 * @return 可以储存的最大水量
 */
fun maxArea(height: IntArray): Int {
    var maxVolume = 0
    var left = 0;
    var right = height.lastIndex

    while (left < right) {
        // 计算当前容器的容量：宽度 * 高度（取两边较小值）
        val currentVolume = (right - left) * minOf(height[left], height[right])
        // 更新最大容量
        maxVolume = maxOf(maxVolume, currentVolume)

        // 移动较短的那条边，因为较短的边限制了容器的高度
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maxVolume
}
