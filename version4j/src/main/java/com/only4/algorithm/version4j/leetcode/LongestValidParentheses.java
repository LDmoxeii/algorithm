package com.only4.algorithm.version4j.leetcode;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // 空字符串直接返回0
        if (s.isEmpty()) return 0;

        // maxValidLengthEndingAt[i] 表示以s[i]结尾的最长有效括号的长度
        int[] maxValidLengthEndingAt = new int[s.length()];
        int globalMaxValidLength = 0;

        // 从索引1开始，因为单个字符不可能形成有效括号
        for (int currentIndex = 1; currentIndex < s.length(); currentIndex++) {
            char currentChar = s.charAt(currentIndex);

            if (currentChar == '(') {
                // 如果是左括号，则以它结尾的子串不可能是有效括号
                maxValidLengthEndingAt[currentIndex] = 0;
            } else { // currentChar == ')'
                char previousChar = s.charAt(currentIndex - 1);

                if (previousChar == '(') {
                    // 情况1: 前一个字符是左括号，形如"...()"
                    // 前面部分的有效括号长度 + 新增的"()"长度2
                    int previousValidLength = (currentIndex >= 2) ?
                            maxValidLengthEndingAt[currentIndex - 2] : 0;
                    maxValidLengthEndingAt[currentIndex] = previousValidLength + 2;
                } else { // previousChar == ')'
                    // 情况2: 前一个字符是右括号，形如"...)))"
                    // 检查是否存在匹配的左括号
                    int previousValidLength = maxValidLengthEndingAt[currentIndex - 1];
                    int potentialMatchingLeftParenIndex = currentIndex - previousValidLength - 1;

                    if (potentialMatchingLeftParenIndex >= 0 &&
                            s.charAt(potentialMatchingLeftParenIndex) == '(') {
                        // 找到匹配的左括号，计算新的有效括号长度
                        int validLengthBeforeMatch = (potentialMatchingLeftParenIndex > 0) ?
                                maxValidLengthEndingAt[potentialMatchingLeftParenIndex - 1] : 0;

                        maxValidLengthEndingAt[currentIndex] =
                                previousValidLength + 2 + validLengthBeforeMatch;
                    }
                }
            }

            // 更新全局最长有效括号长度
            globalMaxValidLength = Math.max(globalMaxValidLength, maxValidLengthEndingAt[currentIndex]);
        }

        return globalMaxValidLength;
    }
}
