package com.only4.algorithm.version4j.leetcode;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            Math.min(
                                    dp[i][j - 1] + 1,     // 插入操作
                                    dp[i - 1][j] + 1      // 删除操作
                            ),
                            dp[i - 1][j - 1] + 1   // 替换操作
                    );
                }
            }
        }

        return dp[m][n];
    }
}
