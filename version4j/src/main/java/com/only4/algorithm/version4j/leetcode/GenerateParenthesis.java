package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int totalParenthesesPairs) {
        List<String> allValidParenthesesCombinations = new ArrayList<>();
        StringBuilder currentParenthesesSequence = new StringBuilder();

        buildValidParenthesesWithBacktracking(
                totalParenthesesPairs,
                0,  // 初始左括号数量
                0,  // 初始右括号数量
                currentParenthesesSequence,
                allValidParenthesesCombinations
        );
        return allValidParenthesesCombinations;
    }

    /**
     * 使用回溯算法构建所有有效的括号组合
     *
     * @param totalParenthesesPairs           需要生成的括号对数
     * @param currentLeftParenthesesCount     当前序列中左括号的数量
     * @param currentRightParenthesesCount    当前序列中右括号的数量
     * @param currentParenthesesSequence      当前正在构建的括号序列
     * @param allValidParenthesesCombinations 存储所有有效括号组合的结果集
     */
    private void buildValidParenthesesWithBacktracking(
            int totalParenthesesPairs,
            int currentLeftParenthesesCount,
            int currentRightParenthesesCount,
            StringBuilder currentParenthesesSequence,
            List<String> allValidParenthesesCombinations) {

        // 终止条件：序列长度达到2n，找到一个完整的有效括号组合
        if (currentParenthesesSequence.length() == totalParenthesesPairs * 2) {
            allValidParenthesesCombinations.add(currentParenthesesSequence.toString());
            return;
        }

        // 选择1：添加左括号（条件：左括号数量未达到上限）
        if (currentLeftParenthesesCount < totalParenthesesPairs) {
            // 选择：添加左括号
            currentParenthesesSequence.append('(');

            // 递归：继续构建序列，左括号数量+1
            buildValidParenthesesWithBacktracking(
                    totalParenthesesPairs,
                    currentLeftParenthesesCount + 1,
                    currentRightParenthesesCount,
                    currentParenthesesSequence,
                    allValidParenthesesCombinations
            );

            // 回溯：移除刚添加的左括号，尝试其他可能
            currentParenthesesSequence.deleteCharAt(currentParenthesesSequence.length() - 1);
        }

        // 选择2：添加右括号（条件：右括号数量小于左括号数量，确保括号匹配）
        if (currentLeftParenthesesCount > currentRightParenthesesCount) {
            // 选择：添加右括号
            currentParenthesesSequence.append(')');

            // 递归：继续构建序列，右括号数量+1
            buildValidParenthesesWithBacktracking(
                    totalParenthesesPairs,
                    currentLeftParenthesesCount,
                    currentRightParenthesesCount + 1,
                    currentParenthesesSequence,
                    allValidParenthesesCombinations
            );

            // 回溯：移除刚添加的右括号，尝试其他可能
            currentParenthesesSequence.deleteCharAt(currentParenthesesSequence.length() - 1);
        }
    }
}
