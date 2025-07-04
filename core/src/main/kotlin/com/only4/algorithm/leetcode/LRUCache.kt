package com.only4.algorithm.leetcode

/**
 * [146. LRU缓存](https://leetcode.com/problems/lru-cache/)
 *
 * 设计并实现一个LRU(最近最少使用)缓存机制，它应该支持以下操作：获取数据(get)和写入数据(put)。
 *
 * get(key)：如果关键字key存在于缓存中，则获取key对应的值（总是正数），否则返回-1。
 * put(key, value)：如果关键字key已经存在，则变更其值；如果不存在，则插入该组key-value。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据，从而为新数据留出空间。
 *
 * 解题思路：
 * 使用哈希表和双向链表的组合结构（哈希链表）：
 * 1. 哈希表提供O(1)时间复杂度的数据查找
 * 2. 双向链表用于维护数据的使用顺序，便于O(1)时间移除最久未使用的数据
 * 3. 每次访问数据时，将其移动到链表头部，表示最近使用
 * 4. 缓存满时，移除链表尾部的数据（最久未使用）
 *
 * 时间复杂度：get和put操作均为O(1)
 * 空间复杂度：O(capacity)，存储最多capacity个键值对
 */
class LRUCache(private val capacity: Int) {

    /**
     * 哨兵节点，作为双向链表的头部标记
     * next指向最近使用的节点，prev指向最久未使用的节点
     */
    private val sentinel = Node().apply {
        next = this
        prev = this
    }

    /**
     * 哈希表，用于O(1)时间查找节点
     */
    private val cache = mutableMapOf<Int, Node>()

    /**
     * 双向链表节点类
     *
     * @param key 键
     * @param val 值
     */
    private inner class Node(val key: Int = 0, var `val`: Int = 0) {
        var prev: Node = this
        var next: Node = this

        /**
         * 从链表中移除当前节点
         */
        fun remove() {
            prev.next = next
            next.prev = prev
        }

        /**
         * 将当前节点移动到链表头部（最近使用）
         */
        fun moveToTop() {
            next = sentinel.next
            prev = sentinel

            sentinel.next.prev = this
            sentinel.next = this
        }
    }

    /**
     * 获取缓存中key对应的值
     *
     * @param key 要查询的键
     * @return 如果键存在则返回对应的值，否则返回-1
     */
    fun get(key: Int): Int = getNode(key)?.`val` ?: -1

    /**
     * 获取缓存中key对应的节点，并将其移至链表头部
     *
     * @param key 要查询的键
     * @return 如果键存在则返回对应的节点，否则返回null
     */
    private fun getNode(key: Int): Node? {
        val node = cache[key] ?: return null
        node.remove()
        node.moveToTop()
        return node
    }

    /**
     * 插入或更新缓存
     *
     * @param key 键
     * @param value 值
     */
    fun put(key: Int, value: Int) {
        // 如果键已存在，更新值并移至链表头部
        getNode(key)?.let {
            it.`val` = value
            return
        }

        // 键不存在，创建新节点并添加到链表头部
        Node(key, value).also { newNode ->
            cache[key] = newNode
            newNode.moveToTop()

            // 如果缓存已满，移除最久未使用的节点（链表尾部）
            if (cache.size > capacity) {
                sentinel.prev.also { lastNode ->
                    lastNode.remove()
                    cache.remove(lastNode.key)
                }
            }
        }
    }
}
