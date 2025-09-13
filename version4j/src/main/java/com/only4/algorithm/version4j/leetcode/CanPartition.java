package com.only4.algorithm.version4j.leetcode;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        // 计算数组总和
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 如果总和为奇数，无法分割成两个和相等的子集
        if (totalSum % 2 != 0) return false;

        // 目标和为总和的一半
        int targetSum = totalSum / 2;
        int numCount = nums.length;

        // dp[i][j]表示：使用前i个数字，是否可以组成和为j的子集
        boolean[][] dp = new boolean[numCount + 1][targetSum + 1];

        // 基础情况：空子集的和为0
        dp[0][0] = true;

        // 填充dp数组
        for (int i = 0; i < numCount; i++) {
            int currentNum = nums[i];
            for (int j = 0; j <= targetSum; j++) {
                // 不选择当前数字的情况
                dp[i + 1][j] = dp[i][j];

                // 选择当前数字的情况（如果j >= currentNum）
                if (j >= currentNum) {
                    dp[i + 1][j] = dp[i + 1][j] || dp[i][j - currentNum];
                }
            }
        }

        // 返回最终结果：使用所有数字，是否可以组成和为targetSum的子集
        return dp[numCount][targetSum];
    }
}
