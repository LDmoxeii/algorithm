package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenyu.jiang
 */
public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        // 初始化前缀和哈希表，前缀和为0的出现次数为1
        Map<Long, Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0L, 1);

        return countPathsWithTargetSum(root, 0L, targetSum, prefixSumFrequency);
    }

    private int countPathsWithTargetSum(TreeNode currentNode, long currentPrefixSum,
                                        int targetSum, Map<Long, Integer> prefixSumFrequency) {
        // 边界条件：节点为空
        if (currentNode == null) return 0;

        // 计算当前路径的前缀和
        currentPrefixSum += currentNode.val;

        // 查找符合要求的路径数量：当前前缀和 - 目标值 = 需要查找的前缀和
        int validPathCount = prefixSumFrequency.getOrDefault(currentPrefixSum - targetSum, 0);

        // 将当前前缀和加入哈希表
        prefixSumFrequency.put(currentPrefixSum,
                prefixSumFrequency.getOrDefault(currentPrefixSum, 0) + 1);

        // 递归处理左右子树
        int leftSubtreePaths = countPathsWithTargetSum(currentNode.left, currentPrefixSum,
                targetSum, prefixSumFrequency);
        int rightSubtreePaths = countPathsWithTargetSum(currentNode.right, currentPrefixSum,
                targetSum, prefixSumFrequency);

        // 回溯：移除当前节点的前缀和记录（恢复状态）
        prefixSumFrequency.put(currentPrefixSum,
                prefixSumFrequency.get(currentPrefixSum) - 1);

        return validPathCount + leftSubtreePaths + rightSubtreePaths;
    }
}
