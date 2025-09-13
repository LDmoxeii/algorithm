package com.only4.algorithm.version4j.leetcode;

import com.only4.algorithm.version4j.extra.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenyu.jiang
 */
public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currentSum += node.val;

        // 查找符合要求的路径数量
        int pathCount = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        // 更新当前前缀和的出现次数
        prefixSumCount.merge(currentSum, 1, Integer::sum);

        // 递归处理左右子树
        int totalPaths = pathCount + dfs(node.left, currentSum, targetSum, prefixSumCount)
                + dfs(node.right, currentSum, targetSum, prefixSumCount);

        // 回溯，恢复状态
        prefixSumCount.merge(currentSum, -1, Integer::sum);

        return totalPaths;
    }
}
