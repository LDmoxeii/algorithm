package com.only4.algorithm.version4k.leetcode

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
