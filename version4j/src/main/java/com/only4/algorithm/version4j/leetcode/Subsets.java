package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] originalElements) {
        List<List<Integer>> allPowerSetSubsets = new ArrayList<>();
        ArrayDeque<Integer> currentSubsetPath = new ArrayDeque<>();

        generateAllSubsetsWithBacktracking(
                originalElements,
                0,  // 从第0个元素开始考虑
                currentSubsetPath,
                allPowerSetSubsets
        );
        return allPowerSetSubsets;
    }

    /**
     * 使用回溯算法生成所有子集（幂集）
     *
     * @param originalElements   原始元素数组
     * @param nextElementIndex   下一个要考虑的元素索引
     * @param currentSubsetPath  当前正在构建的子集路径
     * @param allPowerSetSubsets 存储所有子集的幂集结果
     */
    private void generateAllSubsetsWithBacktracking(
            int[] originalElements,
            int nextElementIndex,
            ArrayDeque<Integer> currentSubsetPath,
            List<List<Integer>> allPowerSetSubsets) {

        // 将当前子集路径添加到幂集结果中（包括空集）
        allPowerSetSubsets.add(new ArrayList<>(currentSubsetPath));

        // 从nextElementIndex开始，尝试添加每个后续元素到当前子集
        for (int candidateIndex = nextElementIndex; candidateIndex < originalElements.length; candidateIndex++) {
            int candidateElement = originalElements[candidateIndex];

            // 选择：将候选元素添加到当前子集路径
            currentSubsetPath.addLast(candidateElement);

            // 递归：继续构建包含当前元素的所有子集
            // 注意：下次递归从candidateIndex + 1开始，确保不重复选择同一元素
            generateAllSubsetsWithBacktracking(
                    originalElements,
                    candidateIndex + 1,
                    currentSubsetPath,
                    allPowerSetSubsets
            );

            // 回溯：移除刚添加的元素，尝试其他可能的组合
            currentSubsetPath.removeLast();
        }
    }
}
