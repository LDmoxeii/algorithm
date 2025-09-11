package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Search算法的单元测试
 * 用于测试旋转排序数组的查找
 */
public class SearchTest {
    private Search search;

    @BeforeEach
    public void setUp() {
        search = new Search();
    }

    @Test
    public void testFindMinIndex() {
        // 测试最小值索引查找
        assertEquals(2, search.findMin(new int[]{4, 5, 1, 2, 3}));
        assertEquals(0, search.findMin(new int[]{1, 2, 3, 4, 5}));
        assertEquals(1, search.findMin(new int[]{5, 1, 2, 3, 4}));
        assertEquals(0, search.findMin(new int[]{1}));
        assertEquals(1, search.findMin(new int[]{2, 1}));
    }

    @Test
    public void testSearchInRotatedArray() {
        // 旋转数组中查找目标值
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(4, search.search(nums, 0));
        assertEquals(5, search.search(nums, 1));
        assertEquals(6, search.search(nums, 2));
        assertEquals(0, search.search(nums, 4));
        assertEquals(-1, search.search(nums, 3));
    }

    @Test
    public void testSearchInSortedArray() {
        // 非旋转数组查找
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(0, search.search(nums, 1));
        assertEquals(6, search.search(nums, 7));
        assertEquals(-1, search.search(nums, 8));
    }

    @Test
    public void testSearchSingleElement() {
        // 单元素数组
        int[] nums = {1};
        assertEquals(0, search.search(nums, 1));
        assertEquals(-1, search.search(nums, 2));
    }

    @Test
    public void testSearchTwoElements() {
        // 两元素数组
        int[] nums = {3, 1};
        assertEquals(0, search.search(nums, 3));
        assertEquals(1, search.search(nums, 1));
        assertEquals(-1, search.search(nums, 2));
    }
}
