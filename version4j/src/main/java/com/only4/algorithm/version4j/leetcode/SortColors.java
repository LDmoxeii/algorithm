package com.only4.algorithm.version4j.leetcode;

public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;

        while (mid <= right) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, left, mid);
                    left++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, right);
                    right--;
                    break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
