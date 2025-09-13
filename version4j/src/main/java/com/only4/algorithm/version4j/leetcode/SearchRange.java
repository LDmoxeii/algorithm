package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int leftBound = findLeftBound(nums, target);
        int rightBound = findRightBound(nums, target);
        return new int[]{leftBound, rightBound};
    }

    private int findLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left < 0 || left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int findRightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right < 0 || right >= nums.length || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
