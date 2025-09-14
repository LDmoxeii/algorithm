package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class Partition {

    public List<List<String>> partition(String originalString) {
        List<List<String>> allPalindromePartitions = new ArrayList<>();
        ArrayDeque<String> currentPartitionPath = new ArrayDeque<>();

        findAllPalindromePartitionsWithBacktracking(
                originalString,
                0,  // 从字符串的第0个位置开始分割
                currentPartitionPath,
                allPalindromePartitions
        );
        return allPalindromePartitions;
    }

    /**
     * 使用回溯算法寻找所有可能的回文串分割方案
     *
     * @param originalString          要分割的原始字符串
     * @param currentSplitStartIndex  当前分割的起始位置索引
     * @param currentPartitionPath    当前正在构建的分割路径
     * @param allPalindromePartitions 存储所有回文分割方案的结果集
     */
    private void findAllPalindromePartitionsWithBacktracking(
            String originalString,
            int currentSplitStartIndex,
            ArrayDeque<String> currentPartitionPath,
            List<List<String>> allPalindromePartitions) {

        // 终止条件：已经处理完整个字符串，找到一个完整的回文分割方案
        if (currentSplitStartIndex == originalString.length()) {
            allPalindromePartitions.add(new ArrayList<>(currentPartitionPath));
            return;
        }

        // 尝试从当前起始位置到字符串末尾的每个可能的结束位置
        for (int candidateEndIndex = currentSplitStartIndex; candidateEndIndex < originalString.length(); candidateEndIndex++) {
            // 检查当前候选子串是否为回文串
            if (isSubstringPalindrome(originalString, currentSplitStartIndex, candidateEndIndex)) {
                // 选择：将回文子串添加到当前分割路径
                String palindromeSubstring = originalString.substring(currentSplitStartIndex, candidateEndIndex + 1);
                currentPartitionPath.addLast(palindromeSubstring);

                // 递归：继续分割剩余字符串
                findAllPalindromePartitionsWithBacktracking(
                        originalString,
                        candidateEndIndex + 1,  // 从下一个位置开始继续分割
                        currentPartitionPath,
                        allPalindromePartitions
                );

                // 回溯：移除刚添加的子串，尝试其他分割可能性
                currentPartitionPath.removeLast();
            }
        }
    }

    /**
     * 检查字符串指定范围内的子串是否为回文串
     *
     * @param targetString  目标字符串
     * @param leftBoundary  子串的左边界索引（包含）
     * @param rightBoundary 子串的右边界索引（包含）
     * @return 指定子串是否为回文串
     */
    private boolean isSubstringPalindrome(String targetString, int leftBoundary, int rightBoundary) {
        while (leftBoundary < rightBoundary) {
            if (targetString.charAt(leftBoundary++) != targetString.charAt(rightBoundary--)) {
                return false;
            }
        }
        return true;
    }
}
