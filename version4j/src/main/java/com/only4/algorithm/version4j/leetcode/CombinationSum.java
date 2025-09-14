package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidateNumbers, int targetSum) {
        List<List<Integer>> allValidCombinations = new ArrayList<>();
        // 排序候选数组，便于剪枝优化
        Arrays.sort(candidateNumbers);
        ArrayDeque<Integer> currentCombinationPath = new ArrayDeque<>();

        findCombinationsWithBacktracking(
                candidateNumbers,
                0,  // 从第0个候选数字开始考虑
                targetSum,
                currentCombinationPath,
                allValidCombinations
        );
        return allValidCombinations;
    }

    /**
     * 使用回溯算法寻找所有和等于目标值的组合
     *
     * @param candidateNumbers       候选数字数组（已排序）
     * @param startingCandidateIndex 开始考虑的候选数字索引
     * @param remainingTargetSum     还需要达到的目标和值
     * @param currentCombinationPath 当前正在构建的组合路径
     * @param allValidCombinations   存储所有有效组合的结果集
     */
    private void findCombinationsWithBacktracking(
            int[] candidateNumbers,
            int startingCandidateIndex,
            int remainingTargetSum,
            ArrayDeque<Integer> currentCombinationPath,
            List<List<Integer>> allValidCombinations) {

        // 终止条件1：找到一个有效组合，剩余目标和为0
        if (remainingTargetSum == 0) {
            allValidCombinations.add(new ArrayList<>(currentCombinationPath));
            return;
        }

        // 终止条件2：剩余目标和小于0，当前路径无效
        if (remainingTargetSum < 0) {
            return;
        }

        // 从startingCandidateIndex开始尝试每个候选数字
        for (int candidateIndex = startingCandidateIndex; candidateIndex < candidateNumbers.length; candidateIndex++) {
            int currentCandidateNumber = candidateNumbers[candidateIndex];

            // 剪枝优化：如果当前候选数字大于剩余目标和，由于数组已排序，后续数字也都大于目标和
            if (currentCandidateNumber > remainingTargetSum) {
                break;
            }

            // 选择：将当前候选数字添加到组合路径
            currentCombinationPath.addLast(currentCandidateNumber);

            // 递归：继续寻找组合，注意传入candidateIndex而非candidateIndex + 1，允许重复使用同一数字
            findCombinationsWithBacktracking(
                    candidateNumbers,
                    candidateIndex,  // 允许重复使用当前数字
                    remainingTargetSum - currentCandidateNumber,
                    currentCombinationPath,
                    allValidCombinations
            );

            // 回溯：移除刚添加的数字，尝试其他可能的选择
            currentCombinationPath.removeLast();
        }
    }
}
