package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSquares {
    public int numSquares(int n) {
        // 收集所有小于等于n的完全平方数
        List<Integer> perfectSquares = new ArrayList<>();
        int sqrtValue = 1;
        while (sqrtValue * sqrtValue <= n) {
            perfectSquares.add(sqrtValue * sqrtValue);
            sqrtValue++;
        }

        // 创建dp数组，初始值设为最大整数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 组成0需要0个完全平方数

        // 对于每个数字，尝试使用每个完全平方数来减少它
        for (int currentNum = 1; currentNum <= n; currentNum++) {
            for (int square : perfectSquares) {
                if (currentNum < square) break; // 完全平方数太大，无法使用

                // 使用当前完全平方数后，更新dp[currentNum]
                dp[currentNum] = Math.min(dp[currentNum], dp[currentNum - square] + 1);
            }
        }

        return dp[n];
    }
}
