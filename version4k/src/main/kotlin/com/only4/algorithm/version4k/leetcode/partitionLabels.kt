package com.only4.algorithm.version4k.leetcode

/**
 * [763. 划分字母区间](https://leetcode.com/problems/partition-labels/)
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 示例:
 * - 输入: S = "ababcbacadefegdehijhklij"
 * - 输出: [9,7,8]
 * - 解释:
 *   划分结果为 "ababcbaca", "defegde", "hijhklij"。
 *   每个字母最多出现在一个片段中。
 *   像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 解题思路:
 * 1. 首先遍历字符串，记录每个字符最后出现的位置
 * 2. 再次遍历字符串，维护当前片段的结束位置end
 * 3. 如果当前遍历到的位置i等于end，说明找到了一个片段的结束位置
 * 4. 将该片段的长度加入结果列表，并更新下一个片段的起始位置
 *
 * 时间复杂度: O(n)，其中n是字符串长度，需要遍历两次字符串
 * 空间复杂度: O(1)，因为字母最多只有26个，所以存储最后位置的数组大小是常数级别
 *
 * @param s 输入的字符串
 * @return 表示每个字符串片段的长度的列表
 */
fun partitionLabels(s: String): List<Int> {
    // 如果字符串为空，直接返回空列表
    if (s.isEmpty()) return emptyList()

    // 创建一个数组来存储每个字符最后出现的位置
    val lastPositions = IntArray(26)

    // 第一次遍历：记录每个字符最后出现的位置
    for (i in s.indices) {
        lastPositions[s[i] - 'a'] = i
    }

    // 存储结果的列表
    val result = mutableListOf<Int>()

    // 当前片段的起始位置
    var start = 0
    // 当前片段的结束位置
    var end = 0

    // 第二次遍历：确定每个片段的边界
    for (i in s.indices) {
        // 更新当前片段的结束位置，取当前结束位置和当前字符最后出现位置的较大值
        end = maxOf(end, lastPositions[s[i] - 'a'])

        // 如果当前位置等于结束位置，说明找到了一个片段
        if (i == end) {
            // 计算片段长度并添加到结果列表
            result.add(end - start + 1)
            // 更新下一个片段的起始位置
            start = i + 1
        }
    }

    return result
}
