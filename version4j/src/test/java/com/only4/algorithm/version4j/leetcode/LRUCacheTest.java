package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheTest {

    @Test
    public void testBasicOperations() {
        LRUCache cache = new LRUCache(2);

        // 测试放入和获取
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1)); // 返回 1
        assertEquals(2, cache.get(2)); // 返回 2
        assertEquals(-1, cache.get(3)); // 返回 -1 (未找到)

        // 测试LRU替换
        cache.put(3, 3);    // 该操作会使key=1的数据被淘汰
        assertEquals(-1, cache.get(1));  // 返回 -1 (未找到)
        assertEquals(2, cache.get(2));   // 返回 2
        assertEquals(3, cache.get(3));   // 返回 3

        // 测试更新现有值
        cache.put(2, 4);    // 更新key=2的值为4
        assertEquals(4, cache.get(2));   // 返回 4

        // 测试访问后的LRU顺序
        cache.put(4, 4);    // 该操作会使key=3的数据被淘汰(因为2刚被访问)
        assertEquals(-1, cache.get(3));  // 返回 -1 (未找到)
        assertEquals(4, cache.get(2));   // 返回 4
        assertEquals(4, cache.get(4));   // 返回 4
    }

    @Test
    public void testSingleCapacity() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 1);
        assertEquals(1, cache.get(1));

        cache.put(2, 2);
        assertEquals(-1, cache.get(1)); // key=1已被淘汰
        assertEquals(2, cache.get(2));

        cache.put(3, 3);
        assertEquals(-1, cache.get(2)); // key=2已被淘汰
        assertEquals(3, cache.get(3));
    }

    @Test
    public void testLargeCapacity() {
        // 测试较大容量
        LRUCache cache = new LRUCache(10);
        for (int i = 1; i <= 10; i++) {
            cache.put(i, i);
        }

        // 所有键都应该存在
        for (int i = 1; i <= 10; i++) {
            assertEquals(i, cache.get(i));
        }

        // 添加一个新键，最旧的键(1)应该被淘汰
        cache.put(11, 11);
        assertEquals(-1, cache.get(1));
        assertEquals(11, cache.get(11));

        // 访问一个键，使其变为最近使用
        assertEquals(2, cache.get(2));

        // 再添加一个新键，现在最旧的键(3)应该被淘汰
        cache.put(12, 12);
        assertEquals(-1, cache.get(3));
        assertEquals(12, cache.get(12));
    }

    @Test
    public void testRepeatAccess() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);

        // 重复访问key=1
        for (int i = 0; i < 5; i++) {
            assertEquals(1, cache.get(1));
        }

        // 添加新键，key=2应该被淘汰
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        assertEquals(1, cache.get(1));
        assertEquals(3, cache.get(3));
    }

    @Test
    public void testUpdateExistingKey() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);

        // 更新key=1的值
        cache.put(1, 100);
        assertEquals(100, cache.get(1));

        // 验证LRU状态：key=1现在是最近使用的
        cache.put(3, 3);
        assertEquals(-1, cache.get(2)); // key=2应该被淘汰
        assertEquals(100, cache.get(1));
        assertEquals(3, cache.get(3));
    }
}
