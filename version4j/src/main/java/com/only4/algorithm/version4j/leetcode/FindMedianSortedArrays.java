package com.only4.algorithm.version4j.leetcode;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int totalL = (n + m + 1) / 2;

        int left = 0, right = n;
        while (left <= right) {
            // [0, le1 - 1]
            int le1 = left + (right - left) / 2;
            // [0, le2 - 1]
            int le2 = totalL - le1;

            int nums1LM = le1 == 0 ? Integer.MIN_VALUE : nums1[le1 - 1];
            int nums1RM = le1 == n ? Integer.MAX_VALUE : nums1[le1];
            int nums2LM = le2 == 0 ? Integer.MIN_VALUE : nums2[le2 - 1];
            int nums2RM = le2 == m ? Integer.MAX_VALUE : nums2[le2];

            if (nums1LM <= nums2RM && nums2LM <= nums1RM) {
                if ((m + n) % 2 == 0) {
                    return (double)(Math.max(nums1LM, nums2LM) + Math.min(nums1RM, nums2RM)) / 2;
                } else {
                    return Math.max(nums1LM, nums2LM);
                }
            } else {
                if (nums1LM > nums2RM) {
                    right--;
                } else left++;
            }
        }

        throw new RuntimeException();
    }
}
