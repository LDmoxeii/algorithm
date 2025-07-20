package com.only4.algorithm.version4j.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMedianSortedArraysTest {

    private final double DELTA = 0.00001;

    @Test
    public void testBothArraysNonEmptyEvenLength() {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        // 合并后为 [1, 2, 3, 4]，中位数为 (2 + 3) / 2 = 2.5
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testBothArraysNonEmptyOddLength() {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        // 合并后为 [1, 2, 3]，中位数为 2
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testOneEmptyArray() {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4, 5};
        // 合并后为 [1, 2, 3, 4, 5]，中位数为 3
        assertEquals(3.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testEqualLengthArrays() {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6, 8};
        // 合并后为 [1, 2, 3, 4, 5, 6, 7, 8]，中位数为 (4 + 5) / 2 = 4.5
        assertEquals(4.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testDifferentLengthArrays() {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4, 5, 6, 7, 8, 9};
        // 合并后为 [1, 2, 3, 4, 5, 6, 7, 8, 9]，中位数为 5
        assertEquals(5.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testWithLargeValues() {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] nums1 = {100000};
        int[] nums2 = {100001};
        // 合并后为 [100000, 100001]，中位数为 (100000 + 100001) / 2 = 100000.5
        assertEquals(100000.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testWithNegativeValues() {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] nums1 = {-10, -5, 0, 5};
        int[] nums2 = {-20, -15, 10, 15};
        // 合并后为 [-20, -15, -10, -5, 0, 5, 10, 15]，中位数为 (-5 + 0) / 2 = -2.5
        assertEquals(-2.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testFirstArrayLargerThanSecond() {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {7, 8};
        // 合并后为 [1, 2, 3, 4, 5, 6, 7, 8]，中位数为 (4 + 5) / 2 = 4.5
        assertEquals(4.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testSecondArrayLargerThanFirst() {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] nums1 = {7, 8};
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        // 合并后为 [1, 2, 3, 4, 5, 6, 7, 8]，中位数为 (4 + 5) / 2 = 4.5
        assertEquals(4.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testOverlappingArrays() {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 3, 5, 7};
        // 合并后为 [1, 2, 3, 3, 5, 5, 7, 7]，中位数为 (3 + 5) / 2 = 4
        assertEquals(4.0, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }

    @Test
    public void testSingleElementArrays() {
        FindMedianSortedArrays solution = new FindMedianSortedArrays();
        int[] nums1 = {1};
        int[] nums2 = {2};
        // 合并后为 [1, 2]，中位数为 (1 + 2) / 2 = 1.5
        assertEquals(1.5, solution.findMedianSortedArrays(nums1, nums2), DELTA);
    }
}
