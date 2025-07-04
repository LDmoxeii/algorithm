package com.only4.algorithm.leetcode

import com.only4.algorithm.extra.ListNode

/**
 * [131. 分割回文串](https://leetcode.com/problems/palindrome-partitioning/)
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 *
 * 解题思路：
 * 使用回溯算法，对于每个位置，有两种选择：
 * 1. 切割，如果切割出的子串是回文串，则将其加入路径，并继续处理剩余部分
 * 2. 不切割，继续向后扩展当前子串
 *
 * 时间复杂度：O(n * 2^n)，其中n是字符串长度
 * 空间复杂度：O(n)，递归调用栈的深度最大为n
 */
fun partition(s: String): List<List<String>> {
    val result = mutableListOf<List<String>>()
    val path = mutableListOf<String>()

    /**
     * 回溯函数，用于生成所有可能的分割方案
     *
     * @param start 当前考虑的子串的起始位置
     * @param end 当前考虑的子串的结束位置
     */
    fun dfs(start: Int, end: Int) {
        // 如果已经处理到字符串末尾，将当前路径添加到结果中
        if (end == s.length) {
            result.add(path.toList())
            return
        }

        // 选择不切割，继续扩展当前子串
        if (end < s.lastIndex) {
            dfs(start, end + 1)
        }

        // 选择切割，检查子串是否为回文串
        val subString = s.substring(start, end + 1)
        if (subString == subString.reversed()) {
            path.add(subString)
            dfs(end + 1, end + 1)
            path.removeAt(path.lastIndex) // 回溯，移除最后添加的子串
        }
    }

    dfs(0, 0)
    return result
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
