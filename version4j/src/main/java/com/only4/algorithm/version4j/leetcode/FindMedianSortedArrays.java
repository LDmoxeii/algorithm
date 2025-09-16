package com.only4.algorithm.version4j.leetcode;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短的数组，优化二分查找效率
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        int halfLength = (totalLength + 1) / 2; // 左半部分的长度

        // 在较短数组上进行二分查找
        int left = 0;
        int right = m;

        while (left <= right) {
            // nums1 的分割位置：左侧有 cut1 个元素
            int cut1 = (left + right) / 2;
            // nums2 的分割位置：左侧有 cut2 个元素
            int cut2 = halfLength - cut1;

            // 处理边界情况：分割线左侧的最大值
            int maxLeftNums1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int maxLeftNums2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            // 处理边界情况：分割线右侧的最小值
            int minRightNums1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int minRightNums2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            // 检查分割是否正确
            if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
                // 找到了正确的分割位置
                if (totalLength % 2 == 0) {
                    // 偶数个元素：中位数是中间两个数的平均值
                    int maxLeft = Math.max(maxLeftNums1, maxLeftNums2);
                    int minRight = Math.min(minRightNums1, minRightNums2);
                    return (maxLeft + minRight) / 2.0;
                } else {
                    // 奇数个元素：中位数是左半部分的最大值
                    return Math.max(maxLeftNums1, maxLeftNums2);
                }
            } else if (maxLeftNums1 > minRightNums2) {
                // nums1 分割位置太靠右，需要左移
                right = cut1 - 1;
            } else {
                // nums1 分割位置太靠左，需要右移
                left = cut1 + 1;
            }
        }

        // 理论上不会到达这里
        throw new IllegalArgumentException("Input arrays are not sorted or invalid");
    }
}
