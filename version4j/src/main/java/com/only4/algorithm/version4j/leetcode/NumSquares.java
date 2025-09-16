package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSquares {
    public int numSquares(int n) {
        // 预处理：收集所有小于等于n的完全平方数
        List<Integer> availablePerfectSquares = new ArrayList<>();
        int baseNumber = 1;
        while (baseNumber * baseNumber <= n) {
            int perfectSquare = baseNumber * baseNumber;
            availablePerfectSquares.add(perfectSquare);
            baseNumber++;
        }

        // 创建DP数组：minSquareCount[i] 表示组成数字i所需的最少完全平方数个数
        int[] minSquareCount = new int[n + 1];
        Arrays.fill(minSquareCount, Integer.MAX_VALUE);
        minSquareCount[0] = 0; // 组成0需要0个完全平方数

        // 对于每个目标数字，尝试使用每个可用的完全平方数
        for (int targetNumber = 1; targetNumber <= n; targetNumber++) {
            for (int perfectSquare : availablePerfectSquares) {
                // 如果完全平方数大于目标数字，则无法使用（后续的更大）
                if (targetNumber < perfectSquare) break;

                // 状态转移：使用当前完全平方数后，更新最少个数
                int countAfterUsingSquare = minSquareCount[targetNumber - perfectSquare] + 1;
                minSquareCount[targetNumber] = Math.min(
                        minSquareCount[targetNumber],
                        countAfterUsingSquare
                );
            }
        }

        return minSquareCount[n];
    }
}
