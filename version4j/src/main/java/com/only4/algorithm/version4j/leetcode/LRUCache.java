package com.only4.algorithm.version4j.leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    /**
     * 缓存容量
     */
    private final int cacheCapacity;

    /**
     * 哈希表，用于O(1)时间查找节点
     */
    private final Map<Integer, CacheNode> keyToNodeMap;

    /**
     * 哨兵节点，作为双向链表的头部标记
     */
    private final CacheNode sentinelHead = new CacheNode();

    /**
     * 哨兵节点，作为双向链表的尾部标记
     */
    private final CacheNode sentinelTail = new CacheNode();

    /**
     * 双向链表节点类
     */
    static class CacheNode {
        int key, value;
        CacheNode prev, next;

        CacheNode() {
        }

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.cacheCapacity = capacity;
        this.keyToNodeMap = new HashMap<>();

        // 初始化哨兵节点，形成空的双向链表
        sentinelHead.next = sentinelTail;
        sentinelTail.prev = sentinelHead;
    }

    /**
     * 获取缓存中key对应的值
     *
     * @param key 要查询的键
     * @return 如果键存在则返回对应的值，否则返回-1
     */
    public int get(int key) {
        CacheNode targetNode = keyToNodeMap.get(key);
        if (targetNode == null) return -1;

        // 访问节点后，将其移动到链表头部（表示最近使用）
        moveToHead(targetNode);
        return targetNode.value;
    }

    /**
     * 插入或更新缓存
     *
     * @param key   键
     * @param value 值
     */
    public void put(int key, int value) {
        CacheNode existingNode = keyToNodeMap.get(key);

        if (existingNode != null) {
            // 键已存在，更新值并移至链表头部
            existingNode.value = value;
            moveToHead(existingNode);
        } else {
            // 键不存在，创建新节点
            CacheNode newNode = new CacheNode(key, value);
            keyToNodeMap.put(key, newNode);
            addToHead(newNode);

            // 如果缓存已满，移除最久未使用的节点（链表尾部）
            if (keyToNodeMap.size() > cacheCapacity) {
                CacheNode oldestNode = removeTail();
                keyToNodeMap.remove(oldestNode.key);
            }
        }
    }

    /**
     * 将节点添加到链表头部（最近使用位置）
     */
    private void addToHead(CacheNode node) {
        node.prev = sentinelHead;
        node.next = sentinelHead.next;

        sentinelHead.next.prev = node;
        sentinelHead.next = node;
    }

    /**
     * 从链表中移除指定节点
     */
    private void removeNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 将节点移动到链表头部
     */
    private void moveToHead(CacheNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 移除并返回链表尾部节点（最久未使用的节点）
     */
    private CacheNode removeTail() {
        CacheNode oldestNode = sentinelTail.prev;
        removeNode(oldestNode);
        return oldestNode;
    }
}
