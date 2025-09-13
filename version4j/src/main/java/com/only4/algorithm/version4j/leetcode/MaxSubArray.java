package com.only4.algorithm.version4j.leetcode;

/**
 * @author zhenyu.jiang
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 状态转移：选择加入前面的子数组或重新开始
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // 更新全局最大和
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
