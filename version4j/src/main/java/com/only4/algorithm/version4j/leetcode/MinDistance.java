package com.only4.algorithm.version4j.leetcode;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int sourceWordLength = word1.length();
        int targetWordLength = word2.length();
        // minOperations[sourceIndex][targetIndex] 表示将 word1[0...sourceIndex-1] 转换为 word2[0...targetIndex-1] 所需的最少操作数
        int[][] minOperations = new int[sourceWordLength + 1][targetWordLength + 1];

        // 初始化边界条件：将空字符串转换为 word2 的前缀需要插入操作
        for (int targetIndex = 0; targetIndex <= targetWordLength; targetIndex++) {
            minOperations[0][targetIndex] = targetIndex; // 插入 targetIndex 个字符
        }

        // 初始化边界条件：将 word1 的前缀转换为空字符串需要删除操作
        for (int sourceIndex = 0; sourceIndex <= sourceWordLength; sourceIndex++) {
            minOperations[sourceIndex][0] = sourceIndex; // 删除 sourceIndex 个字符
        }

        // 计算所有子问题的最少操作数
        for (int sourceIndex = 1; sourceIndex <= sourceWordLength; sourceIndex++) {
            for (int targetIndex = 1; targetIndex <= targetWordLength; targetIndex++) {
                char sourceChar = word1.charAt(sourceIndex - 1);
                char targetChar = word2.charAt(targetIndex - 1);

                if (sourceChar == targetChar) {
                    // 字符相同，不需要额外操作
                    minOperations[sourceIndex][targetIndex] = minOperations[sourceIndex - 1][targetIndex - 1];
                } else {
                    // 字符不同，考虑三种操作的最小值
                    int insertCost = minOperations[sourceIndex][targetIndex - 1] + 1;     // 插入字符
                    int deleteCost = minOperations[sourceIndex - 1][targetIndex] + 1;     // 删除字符
                    int replaceCost = minOperations[sourceIndex - 1][targetIndex - 1] + 1; // 替换字符

                    minOperations[sourceIndex][targetIndex] = Math.min(
                            Math.min(insertCost, deleteCost),
                            replaceCost
                    );
                }
            }
        }

        return minOperations[sourceWordLength][targetWordLength];
    }
}
