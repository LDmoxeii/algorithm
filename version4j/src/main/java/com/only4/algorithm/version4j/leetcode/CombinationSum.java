package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        ArrayDeque<Integer> path = new ArrayDeque<>();
        backtrack(candidates, 0, target, path, result);
        return result;
    }

    public void backtrack(int[] candidates, int startIndex, int remainingTarget,
                          ArrayDeque<Integer> path, List<List<Integer>> result) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (remainingTarget < 0) return;

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > remainingTarget) break;

            path.addLast(candidates[i]);
            backtrack(candidates, i, remainingTarget - candidates[i], path, result);
            path.removeLast();
        }
    }
}
