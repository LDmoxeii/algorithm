package com.only4.algorithm.version4j.leetcode;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // 创建dp数组，初始化为一个较大的值
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0; // 凑成金额0不需要任何硬币

        // 计算每个金额所需的最少硬币数
        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                // 只有当硬币面额小于等于当前金额时才能使用
                if (currentAmount < coin) continue;
                // 状态转移：使用当前硬币后，所需的最少硬币数
                dp[currentAmount] = Math.min(dp[currentAmount], dp[currentAmount - coin] + 1);
            }
        }

        // 如果dp[amount]仍为初始值，说明无法凑成总金额
        return dp[amount] == Integer.MAX_VALUE / 2 ? -1 : dp[amount];
    }
}
