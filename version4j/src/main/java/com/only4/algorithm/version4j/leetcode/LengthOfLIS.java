package com.only4.algorithm.version4j.leetcode;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        // dp[i]表示以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            // 检查当前元素之前的所有元素
            for (int j = i - 1; j >= 0; j--) {
                // 如果找到一个更小的元素，可以将当前元素接在其后形成更长的递增子序列
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            // 将当前元素本身算入长度
            dp[i]++;

            // 更新全局最大长度
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
