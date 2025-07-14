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
        return pathSum(root, 0, targetSum, prefixSumCount);
    }

    public int pathSum(TreeNode root, long currSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (root == null) return 0;

        currSum += root.val;

        Integer current = prefixSumCount.getOrDefault(currSum - targetSum, 0);

        prefixSumCount.merge(currSum, 1, Integer::sum);

        int totalCount = current + pathSum(root.left, currSum, targetSum, prefixSumCount) + pathSum(root.right, currSum, targetSum, prefixSumCount);

        prefixSumCount.merge(currSum, -1, Integer::sum);

        return totalCount;
    }
}
