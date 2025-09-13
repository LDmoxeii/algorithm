package com.only4.algorithm.version4j.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenyu.jiang
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, path, result);
        return result;
    }

    public void backtrack(int[] nums, boolean[] used, ArrayDeque<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            path.addLast(nums[i]);
            backtrack(nums, used, path, result);
            path.removeLast();
            used[i] = false;
        }
    }
}
