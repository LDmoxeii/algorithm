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
        dfs(candidates, 0, target, new ArrayDeque<>(), result);
        return result;
    }

    public void dfs(int[] candidates, int start, int target, ArrayDeque<Integer> sequence, List<List<Integer>> result) {
        if (target == 0) result.add(new ArrayList<>(sequence));
        if (target <= 0) return;

        for (int i = start; i < candidates.length; i++) {
            sequence.addLast(candidates[i]);
            dfs(candidates, i, target - candidates[i], sequence, result);
            sequence.removeLast();
        }
    }
}
