package com.only4.algorithm.version4j.leetcode;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int firstStringLength = text1.length();
        int secondStringLength = text2.length();
        // lcsLength[firstIndex][secondIndex] 表示 text1[0...firstIndex-1] 和 text2[0...secondIndex-1] 的最长公共子序列长度
        int[][] lcsLength = new int[firstStringLength + 1][secondStringLength + 1];

        // 遍历两个字符串的所有字符组合
        for (int firstIndex = 1; firstIndex <= firstStringLength; firstIndex++) {
            for (int secondIndex = 1; secondIndex <= secondStringLength; secondIndex++) {
                char firstChar = text1.charAt(firstIndex - 1);
                char secondChar = text2.charAt(secondIndex - 1);

                if (firstChar == secondChar) {
                    // 字符相同时：当前LCS长度 = 去掉当前字符后的LCS长度 + 1
                    int previousLcsLength = lcsLength[firstIndex - 1][secondIndex - 1];
                    lcsLength[firstIndex][secondIndex] = previousLcsLength + 1;
                } else {
                    // 字符不同时：取两种情况的最大值
                    int lcsWithoutFirstChar = lcsLength[firstIndex - 1][secondIndex];
                    int lcsWithoutSecondChar = lcsLength[firstIndex][secondIndex - 1];
                    lcsLength[firstIndex][secondIndex] = Math.max(lcsWithoutFirstChar, lcsWithoutSecondChar);
                }
            }
        }

        return lcsLength[firstStringLength][secondStringLength];
    }
}
