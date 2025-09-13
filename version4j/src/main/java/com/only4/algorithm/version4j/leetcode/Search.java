package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class Search {
    public int search(int[] nums, int target) {
        int pivotIndex = findMinIndex(nums);

        if (pivotIndex == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (target > nums[nums.length - 1]) {
            return binarySearch(nums, 0, pivotIndex - 1, target);
        } else {
            return binarySearch(nums, pivotIndex, nums.length - 1, target);
        }
    }

    private int findMinIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
