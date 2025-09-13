package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 第一次遍历：将每个数放到它应该在的位置上
        for (int i = 0; i < n; i++) {
            // 当前数在有效范围内且不在正确位置上时，将其交换到正确位置
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 交换 nums[i] 和 nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 第二次遍历：找到第一个不在正确位置上的元素
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果所有元素都在正确位置上，返回n+1
        return n + 1;
    }
}
