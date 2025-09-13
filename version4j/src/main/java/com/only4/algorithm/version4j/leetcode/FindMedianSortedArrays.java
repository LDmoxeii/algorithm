package com.only4.algorithm.version4j.leetcode;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] mergedArray = new int[totalLength];

        int index = 0, p1 = 0, p2 = 0;

        // 合并两个有序数组
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                mergedArray[index++] = nums1[p1++];
            } else {
                mergedArray[index++] = nums2[p2++];
            }
        }

        // 处理剩余元素
        while (p1 < nums1.length) {
            mergedArray[index++] = nums1[p1++];
        }
        while (p2 < nums2.length) {
            mergedArray[index++] = nums2[p2++];
        }

        // 计算中位数
        if (totalLength % 2 == 0) {
            return (mergedArray[totalLength / 2] + mergedArray[totalLength / 2 - 1]) / 2.0;
        } else {
            return mergedArray[totalLength / 2];
        }
    }
}
