package com.only4.algorithm.version4k.leetcode

import com.only4.algorithm.version4k.extra.ListNode

fun partition(originalString: String): List<List<String>> {
    val allPalindromePartitions = mutableListOf<List<String>>()
    val currentPartitionPath = mutableListOf<String>()

    /**
     * 检查字符串指定范围内的子串是否为回文串
     * @param leftBoundary 子串的左边界索引（包含）
     * @param rightBoundary 子串的右边界索引（包含）
     * @return 指定子串是否为回文串
     */
    fun isSubstringPalindrome(leftBoundary: Int, rightBoundary: Int): Boolean {
        var leftPointer = leftBoundary
        var rightPointer = rightBoundary
        while (leftPointer < rightPointer) {
            if (originalString[leftPointer++] != originalString[rightPointer--]) {
                return false
            }
        }
        return true
    }

    /**
     * 使用回溯算法寻找所有可能的回文串分割方案
     * @param currentSplitStartIndex 当前分割的起始位置索引
     */
    fun findAllPalindromePartitionsWithBacktracking(currentSplitStartIndex: Int) {
        // 终止条件：已经处理完整个字符串，找到一个完整的回文分割方案
        if (currentSplitStartIndex == originalString.length) {
            allPalindromePartitions.add(currentPartitionPath.toList())
            return
        }

        // 尝试从当前起始位置到字符串末尾的每个可能的结束位置
        for (candidateEndIndex in currentSplitStartIndex until originalString.length) {
            // 检查当前候选子串是否为回文串
            if (isSubstringPalindrome(currentSplitStartIndex, candidateEndIndex)) {
                // 选择：将回文子串添加到当前分割路径
                val palindromeSubstring = originalString.substring(currentSplitStartIndex, candidateEndIndex + 1)
                currentPartitionPath.add(palindromeSubstring)

                // 递归：继续分割剩余字符串
                findAllPalindromePartitionsWithBacktracking(candidateEndIndex + 1)

                // 回溯：移除刚添加的子串，尝试其他分割可能性
                currentPartitionPath.removeAt(currentPartitionPath.lastIndex)
            }
        }
    }

    findAllPalindromePartitionsWithBacktracking(0)  // 从字符串的第0个位置开始分割
    return allPalindromePartitions
}

/**
 * [86. 分隔链表](https://leetcode.com/problems/partition-list/)
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 解题思路：
 * 使用两个哑节点分别作为两个链表的头节点，一个链表存储小于x的节点，另一个链表存储大于等于x的节点。
 * 遍历原链表，根据节点值的大小将其连接到对应的链表中。
 * 最后将小值链表的尾部与大值链表的头部相连。
 *
 * 时间复杂度：O(n)，其中n是链表长度
 * 空间复杂度：O(1)，只使用了常数额外空间
 */
fun partition(head: ListNode?, x: Int): ListNode? {
    // 处理空链表的情况
    head ?: return null

    // 创建两个哑节点作为两个链表的头节点
    val smallerHead = ListNode(-10) // 存储小于x的节点
    val greaterHead = ListNode(-20) // 存储大于等于x的节点

    var current = head
    var smallerTail = smallerHead
    var greaterTail = greaterHead

    // 遍历原链表，根据节点值的大小将其连接到对应的链表中
    while (current != null) {
        val next = current.next

        if (current.`val` < x) {
            // 将当前节点连接到小值链表
            smallerTail.next = current
            smallerTail = current
        } else {
            // 将当前节点连接到大值链表
            greaterTail.next = current
            greaterTail = current
        }

        current = next
    }

    // 将小值链表的尾部与大值链表的头部相连
    smallerTail.next = greaterHead.next
    // 大值链表的尾部指向null，防止出现环
    greaterTail.next = null

    return smallerHead.next
}
