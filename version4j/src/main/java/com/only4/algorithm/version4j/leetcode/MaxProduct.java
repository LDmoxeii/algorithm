package com.only4.algorithm.version4j.leetcode;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        // dp[i]表示以nums[i]结尾的子数组的[最小乘积, 最大乘积]
        long[][] dp = new long[nums.length][2];
        long maxResult = nums[0];

        // 初始化第一个元素
        dp[0][0] = nums[0]; // 最小乘积
        dp[0][1] = nums[0]; // 最大乘积

        for (int i = 1; i < nums.length; i++) {
            long currentNum = nums[i];
            long prevMin = dp[i - 1][0];
            long prevMax = dp[i - 1][1];

            // 计算当前位置的最小乘积和最大乘积
            // 需要考虑三种情况：当前数乘以前面最小值、最大值，或者只取当前数
            long currentMin = Math.min(Math.min(currentNum * prevMin, currentNum * prevMax), currentNum);
            long currentMax = Math.max(Math.max(currentNum * prevMin, currentNum * prevMax), currentNum);

            dp[i][0] = currentMin;
            dp[i][1] = currentMax;

            // 更新全局最大乘积
            maxResult = Math.max(maxResult, currentMax);
        }

        return (int)maxResult;
    }
}
