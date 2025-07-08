package com.only4.algorithm.version4k.leetcode

/**
 * [136. 只出现一次的数字](https://leetcode.com/problems/single-number/)
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。你可以不使用额外空间来实现吗？
 *
 * 示例:
 * - 输入: [2,2,1]
 * - 输出: 1
 *
 * - 输入: [4,1,2,1,2]
 * - 输出: 4
 *
 * 解题思路:
 * 使用异或运算的特性来解决此问题。异或运算有以下特点：
 * 1. a ⊕ 0 = a
 * 2. a ⊕ a = 0
 * 3. a ⊕ b ⊕ a = b
 *
 * 由于除了一个元素外，其他元素都出现了两次，那么将所有元素进行异或运算，
 * 相同的元素异或后为0，最终剩下的就是那个只出现一次的元素。
 *
 * 时间复杂度: O(n)，其中n是数组长度
 * 空间复杂度: O(1)，只使用了常数额外空间
 *
 * @param nums 包含重复元素的整数数组，其中只有一个元素出现一次，其余元素均出现两次
 * @return 只出现一次的那个元素
 */
fun singleNumber(nums: IntArray): Int {
    var result = nums[0]
    for (i in 1 until nums.size) {
        result = result xor nums[i]
    }
    return result
}
