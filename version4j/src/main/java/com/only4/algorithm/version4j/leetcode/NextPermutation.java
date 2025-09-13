package com.only4.algorithm.version4j.leetcode;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // 第一步：从右向左找到第一个下降点 nums[i] < nums[i+1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 如果存在这样的 i，进行交换和反转
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 反转 nums[i+1..n-1]
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int from, int to) {
        while (from < to) {
            swap(nums, from, to);
            from++;
            to--;
        }
    }
}
