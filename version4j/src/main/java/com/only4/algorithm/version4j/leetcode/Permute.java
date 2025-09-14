package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class Permute {

    public List<List<Integer>> permute(int[] candidateNumbers) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        ArrayDeque<Integer> currentPermutationPath = new ArrayDeque<>();
        boolean[] isNumberUsedInCurrentPath = new boolean[candidateNumbers.length];

        generatePermutationsWithBacktracking(
                candidateNumbers,
                isNumberUsedInCurrentPath,
                currentPermutationPath,
                allPermutations
        );
        return allPermutations;
    }

    /**
     * 使用回溯算法生成所有排列
     *
     * @param candidateNumbers          候选数字数组
     * @param isNumberUsedInCurrentPath 标记数字是否已在当前路径中使用
     * @param currentPermutationPath    当前正在构建的排列路径
     * @param allPermutations           存储所有完整排列的结果集
     */
    private void generatePermutationsWithBacktracking(
            int[] candidateNumbers,
            boolean[] isNumberUsedInCurrentPath,
            ArrayDeque<Integer> currentPermutationPath,
            List<List<Integer>> allPermutations) {

        // 终止条件：当前路径长度等于候选数字总数，说明找到一个完整排列
        if (currentPermutationPath.size() == candidateNumbers.length) {
            allPermutations.add(new ArrayList<>(currentPermutationPath));
            return;
        }

        // 遍历所有候选数字，尝试将其加入当前排列路径
        for (int candidateIndex = 0; candidateIndex < candidateNumbers.length; candidateIndex++) {
            // 剪枝：跳过已经在当前路径中使用的数字
            if (isNumberUsedInCurrentPath[candidateIndex]) {
                continue;
            }

            // 选择：将候选数字添加到当前路径，并标记为已使用
            int currentCandidateNumber = candidateNumbers[candidateIndex];
            isNumberUsedInCurrentPath[candidateIndex] = true;
            currentPermutationPath.addLast(currentCandidateNumber);

            // 递归：继续构建下一层排列
            generatePermutationsWithBacktracking(
                    candidateNumbers,
                    isNumberUsedInCurrentPath,
                    currentPermutationPath,
                    allPermutations
            );

            // 回溯：撤销当前选择，恢复状态以尝试其他可能性
            currentPermutationPath.removeLast();
            isNumberUsedInCurrentPath[candidateIndex] = false;
        }
    }
}
