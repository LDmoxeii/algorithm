package com.only4.algorithm.version4k.leetcode

class LRUCache(private val cacheCapacity: Int) {

    /**
     * 哈希表，用于O(1)时间查找节点
     */
    private val keyToNodeMap = mutableMapOf<Int, CacheNode>()

    /**
     * 哨兵节点，作为双向链表的头部标记
     */
    private val sentinelHead = CacheNode()

    /**
     * 哨兵节点，作为双向链表的尾部标记
     */
    private val sentinelTail = CacheNode()

    /**
     * 双向链表节点类
     */
    class CacheNode(val key: Int = 0, var value: Int = 0) {
        var prev: CacheNode? = null
        var next: CacheNode? = null
    }

    init {
        // 初始化哨兵节点，形成空的双向链表
        sentinelHead.next = sentinelTail
        sentinelTail.prev = sentinelHead
    }

    /**
     * 获取缓存中key对应的值
     * @param key 要查询的键
     * @return 如果键存在则返回对应的值，否则返回-1
     */
    fun get(key: Int): Int {
        val targetNode = keyToNodeMap[key] ?: return -1

        // 访问节点后，将其移动到链表头部（表示最近使用）
        moveToHead(targetNode)
        return targetNode.value
    }

    /**
     * 插入或更新缓存
     * @param key 键
     * @param value 值
     */
    fun put(key: Int, value: Int) {
        val existingNode = keyToNodeMap[key]

        if (existingNode != null) {
            // 键已存在，更新值并移至链表头部
            existingNode.value = value
            moveToHead(existingNode)
        } else {
            // 键不存在，创建新节点
            val newNode = CacheNode(key, value)
            keyToNodeMap[key] = newNode
            addToHead(newNode)

            // 如果缓存已满，移除最久未使用的节点（链表尾部）
            if (keyToNodeMap.size > cacheCapacity) {
                val oldestNode = removeTail()
                keyToNodeMap.remove(oldestNode.key)
            }
        }
    }

    /**
     * 将节点添加到链表头部（最近使用位置）
     */
    private fun addToHead(node: CacheNode) {
        node.prev = sentinelHead
        node.next = sentinelHead.next

        sentinelHead.next?.prev = node
        sentinelHead.next = node
    }

    /**
     * 从链表中移除指定节点
     */
    private fun removeNode(node: CacheNode) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    /**
     * 将节点移动到链表头部
     */
    private fun moveToHead(node: CacheNode) {
        removeNode(node)
        addToHead(node)
    }

    /**
     * 移除并返回链表尾部节点（最久未使用的节点）
     */
    private fun removeTail(): CacheNode {
        val oldestNode = sentinelTail.prev!!
        removeNode(oldestNode)
        return oldestNode
    }
}
