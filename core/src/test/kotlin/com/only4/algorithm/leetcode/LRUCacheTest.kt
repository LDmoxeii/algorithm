package com.only4.algorithm.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LRUCacheTest {

    @Test
    fun testBasicOperations() {
        val lruCache = LRUCache(2)

        // 测试put和get基本操作
        lruCache.put(1, 1)
        lruCache.put(2, 2)
        assertEquals(1, lruCache.get(1))
        assertEquals(2, lruCache.get(2))

        // 测试put已存在的键，应该更新值
        lruCache.put(1, 10)
        assertEquals(10, lruCache.get(1))
    }

    @Test
    fun testCapacityLimitAndEviction() {
        val lruCache = LRUCache(2)

        // 添加两个元素，达到容量上限
        lruCache.put(1, 1)
        lruCache.put(2, 2)
        assertEquals(1, lruCache.get(1)) // 此时1是最近使用的

        // 添加第三个元素，应该淘汰最久未使用的元素(2)
        lruCache.put(3, 3)
        assertEquals(-1, lruCache.get(2)) // 2应该已被淘汰
        assertEquals(1, lruCache.get(1))
        assertEquals(3, lruCache.get(3))

        // 再添加一个元素，应该淘汰最久未使用的元素(1)
        lruCache.put(4, 4)
        assertEquals(-1, lruCache.get(1)) // 1应该已被淘汰
        assertEquals(3, lruCache.get(3))
        assertEquals(4, lruCache.get(4))
    }

    @Test
    fun testGetNonExistentKey() {
        val lruCache = LRUCache(2)

        // 测试获取不存在的键
        assertEquals(-1, lruCache.get(1))

        lruCache.put(1, 1)
        assertEquals(1, lruCache.get(1))
        assertEquals(-1, lruCache.get(2))
    }

    @Test
    fun testEvictionOrder() {
        val lruCache = LRUCache(3)

        // 添加三个元素
        lruCache.put(1, 1)
        lruCache.put(2, 2)
        lruCache.put(3, 3)

        // 访问1，使1成为最近使用的
        assertEquals(1, lruCache.get(1))

        // 添加第四个元素，应该淘汰最久未使用的元素(2)
        lruCache.put(4, 4)
        assertEquals(-1, lruCache.get(2))
        assertEquals(1, lruCache.get(1))
        assertEquals(3, lruCache.get(3))
        assertEquals(4, lruCache.get(4))

        // 访问3，使3成为最近使用的
        assertEquals(3, lruCache.get(3))

        // 添加第五个元素，应该淘汰最久未使用的元素(1)
        lruCache.put(5, 5)
        assertEquals(-1, lruCache.get(1))
        assertEquals(3, lruCache.get(3))
        assertEquals(4, lruCache.get(4))
        assertEquals(5, lruCache.get(5))
    }

    @Test
    fun testLeetCodeExample() {
        val lruCache = LRUCache(2)

        lruCache.put(1, 1) // 缓存是 {1=1}
        lruCache.put(2, 2) // 缓存是 {1=1, 2=2}
        assertEquals(1, lruCache.get(1)) // 返回 1，缓存是 {2=2, 1=1}

        lruCache.put(3, 3) // 淘汰键 2，缓存是 {1=1, 3=3}
        assertEquals(-1, lruCache.get(2)) // 返回 -1（未找到）

        lruCache.put(4, 4) // 淘汰键 1，缓存是 {3=3, 4=4}
        assertEquals(-1, lruCache.get(1)) // 返回 -1（未找到）
        assertEquals(3, lruCache.get(3)) // 返回 3，缓存是 {4=4, 3=3}
        assertEquals(4, lruCache.get(4)) // 返回 4，缓存是 {3=3, 4=4}
    }

    @Test
    fun testSingleCapacity() {
        val lruCache = LRUCache(1)

        // 测试容量为1的LRU缓存
        lruCache.put(1, 1)
        assertEquals(1, lruCache.get(1))

        lruCache.put(2, 2) // 应该淘汰键1
        assertEquals(-1, lruCache.get(1))
        assertEquals(2, lruCache.get(2))
    }
}
