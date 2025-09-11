package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left, right;
        int first, end;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        if (left < 0 || left > nums.length - 1) {
            first = -1;
        } else if (nums[left] != target) first = -1;
        else first = left;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) left = mid + 1;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        if (right < 0 || right > nums.length - 1) {
            end = -1;
        } else if (nums[right] != target) end = -1;
        else end = right;

        return new int[]{first, end};
    }
}
